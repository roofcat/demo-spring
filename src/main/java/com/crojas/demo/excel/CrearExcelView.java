package com.crojas.demo.excel;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.crojas.demo.model.entities.Contacto;


@Component( "crearExcel" )
public class CrearExcelView extends AbstractXlsView {
	
	
	@SuppressWarnings( "unchecked") 
	@Override
	protected void buildExcelDocument( Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response ) throws Exception {
		
		Collection<Contacto> contactos = (Collection<Contacto>) model.get( "contactos" );
		
		Sheet sheet = workbook.createSheet( "Contactos" );
		
		int rowCount = 0;
		
		Row header = sheet.createRow( rowCount++ );
		header.createCell( 0 ).setCellValue( "ID" );
		header.createCell( 1 ).setCellValue( "FECHA" );
		header.createCell( 2 ).setCellValue( "NOMBRE" );
		header.createCell( 3 ).setCellValue( "CORREO" );
		header.createCell( 4 ).setCellValue( "MENSAJE" );
		
		for ( Contacto contacto : contactos ) {
			
			Row bodyRow = sheet.createRow( rowCount++ );
			bodyRow.createCell( 0 ).setCellValue( contacto.getId() );
			bodyRow.createCell( 1 ).setCellValue( contacto.getFecha() );
			bodyRow.createCell( 2 ).setCellValue( contacto.getNombre() );
			bodyRow.createCell( 3 ).setCellValue( contacto.getCorreo() );
			bodyRow.createCell( 4 ).setCellValue( contacto.getMensaje() );
			
		}
		
		response.setHeader( "Content-Disposition", "attachment; filename=contactos.xls" );
		
	}
	
	
}
