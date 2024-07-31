package com.example.ayd.gift.card.statement.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.MapUtils;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.example.ayd.gift.card.statement.dto.gift.TransactionClearingSummary;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 导出excel工具类
 */
@Slf4j
public abstract class ExportExcelUtil<T> {

    public List<T> datas;

    public Map<String, String> exportParamsMap;

    public void doExport(Class<T> dataClass, List<T> datas, Map<String, String> exportParamsMap) {

        try {
            init(datas, exportParamsMap);

            handleDatas();

            export(dataClass, datas, this.exportParamsMap);

        } catch (Exception e) {
            log.error("导出文件失败:{}，异常导出过程:{}", e, dataClass);
            throw new RuntimeException(e);
        }


    }

    public void init(List<T> datas, Map<String, String> exportParamsMap) {
        this.datas = datas;
        this.exportParamsMap = exportParamsMap;
    }

    /**
     * 进行一些汇总运算与填充特殊数据
     */
    public abstract void handleDatas();

    /**
     * @param dataClass       导出类
     * @param data            导出数据
     * @param exportParamsMap 自定义数据，key - 模板中对应位置, value - 具体数据
     * @param <T>
     */
    public <T> void export(Class<T> dataClass, List<T> data, Map<String, String> exportParamsMap) {

        String exportFileName = exportParamsMap.get("fileName");
        if (Objects.isNull(exportFileName)) throw new RuntimeException("导出文件名不能为空");

        List<List<T>> dataLists = ListUtil.groupList(data, 2000);

        String fileName = TestFileUtil.getPath() + exportFileName + System.currentTimeMillis() + ".xlsx";
        log.info("文件导出地址===>{}", fileName);

        String templateFilePath = "src/main/resources/templates/" + exportFileName + "模板.xlsx";
        String templateFileName = Paths.get(templateFilePath).toAbsolutePath().toString();
        log.info("模板地址===>{}", templateFileName);


        try (ExcelWriter excelWriter = EasyExcel.write(fileName, dataClass).withTemplate(templateFileName).build()) {
            // 这里注意 如果同一个sheet只要创建一次（模板下面的sheet名记得要填exportFileName的值，不然数据注入不进去）
            WriteSheet writeSheet = EasyExcel.writerSheet(exportFileName).build();
            FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();

            dataLists.forEach(datas -> excelWriter.fill(datas, fillConfig, writeSheet));

            Map<String, Object> map = MapUtils.newHashMap();
            exportParamsMap.forEach((k, v) -> map.put(k, v));

            excelWriter.fill(map, writeSheet);
        }
    }
}
