package com.example.learningassist.Data

import com.alibaba.excel.EasyExcel
import com.alibaba.excel.context.AnalysisContext
import com.alibaba.excel.read.listener.ReadListener

class ExcelParser {
    fun parseExcel(filePath: String, onQuestionParsed: (QuestionEntity) -> Unit) {
        EasyExcel.read(filePath, QuestionEntity::class.java, object : ReadListener<QuestionEntity> {
            override fun invoke(data: QuestionEntity, context: AnalysisContext) {
                onQuestionParsed(data)
            }
            
            override fun doAfterAllAnalysed(context: AnalysisContext) {
                // 解析完成后的处理
            }
        }).sheet().doRead()
    }
} 