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
package io.c12.bala.export;

import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author b.palaniappan
 *
 */
public abstract class AbstractPdfView extends AbstractView {
	
	public AbstractPdfView() {
	    setContentType("application/pdf");
	}
	
	@Override
	protected boolean generatesDownloadContent() {
	    return true;
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// IE workaround: write into byte array first.
	    ByteArrayOutputStream baos = createTemporaryOutputStream();

	    // Apply preferences and build metadata.
	    Document document = new Document(PageSize.A4.rotate(), 36, 36, 54, 36);
	    PdfWriter writer = PdfWriter.getInstance(document, baos);
	    prepareWriter(model, writer, request);
	    buildPdfMetadata(model, document, request);

	    // Build PDF document.
	    document.open();
	    buildPdfDocument(model, document, writer, request, response);
	    document.close();

	    // Flush to HTTP response.
	    writeToResponse(response, baos);
	}
	
	protected void prepareWriter(Map<String, Object> model, PdfWriter writer, HttpServletRequest request) throws DocumentException {
	    writer.setViewerPreferences(getViewerPreferences());
	}

	protected int getViewerPreferences() {
	    return PdfWriter.ALLOW_PRINTING | PdfWriter.PageLayoutSinglePage;
	}


	protected void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request) {
	}


	protected abstract void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
