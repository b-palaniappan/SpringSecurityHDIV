/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.c12.bala.export.excel;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

/**
 * @author b.palaniappan
 *
 */
public class ExportToExcel extends AbstractXlsView {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.view.document.AbstractXlsView#buildExcelDocument(java.util.Map, org.apache.poi.ss.usermodel.Workbook, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment; filename=\"my-file.xls\"");
		
		// create excel xls sheet
	    Sheet sheet = workbook.createSheet("User Detail");
	    sheet.setDefaultColumnWidth(30);

	    // create style for header cells
	    CellStyle style = workbook.createCellStyle();
	    Font font = workbook.createFont();
	    font.setFontName("Arial");
	    font.setBold(true);
	    style.setFont(font);
	    
	    // create header row
	    Row header = sheet.createRow(0);
	    header.createCell(0).setCellValue("Firstname");
	    header.getCell(0).setCellStyle(style);
	    header.createCell(1).setCellValue("LastName");
	    header.getCell(1).setCellStyle(style);
	    header.createCell(2).setCellValue("Age");
	    header.getCell(2).setCellStyle(style);
	    header.createCell(3).setCellValue("Job Title");
	    header.getCell(3).setCellStyle(style);
	    header.createCell(4).setCellValue("Company");
	    header.getCell(4).setCellStyle(style);
	    header.createCell(5).setCellValue("Address");
	    header.getCell(5).setCellStyle(style);
	    header.createCell(6).setCellValue("City");
	    header.getCell(6).setCellStyle(style);
	    header.createCell(7).setCellValue("Country");
	    header.getCell(7).setCellStyle(style);
	    header.createCell(8).setCellValue("Phone Number");
	    header.getCell(8).setCellStyle(style);
	}

}
