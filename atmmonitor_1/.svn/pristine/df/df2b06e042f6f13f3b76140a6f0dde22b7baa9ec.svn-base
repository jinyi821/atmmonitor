package com.common.core.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.docx4j.Docx4J;
import org.docx4j.convert.in.Doc;
import org.docx4j.convert.out.FOSettings;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.fonts.PhysicalFont;
import org.docx4j.fonts.PhysicalFonts;
import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.RFonts;

public class DocToPDFConverter extends ConverterWord {

	public DocToPDFConverter(InputStream inStream, OutputStream outStream, boolean showMessages,
			boolean closeStreamsWhenComplete) {
		super(inStream, outStream, showMessages, closeStreamsWhenComplete);
		
	}



	@Override
	public void convert() throws Exception {		 
			loading();		 
			InputStream iStream = inStream;
		/*	String regex =".*(calibri|camb|cour|arial|times|comic|georgia|impact|LSANS|pala|tahoma|trebuc|verdana|symbol|webdings|wingding).*";
			PhysicalFonts.setRegex(regex);*/
				
		    WordprocessingMLPackage wordMLPackage = getMLPackage(iStream);
		    Mapper fontMapper = new IdentityPlusMapper();  
		          fontMapper.put("华文行楷", PhysicalFonts.get("STXingkai"));  
		            fontMapper.put("华文仿宋", PhysicalFonts.get("STFangsong"));  
		                fontMapper.put("隶书", PhysicalFonts.get("LiSu"));  
		                wordMLPackage.setFontMapper(fontMapper); 
//		    Mapper fontMapper = new IdentityPlusMapper();			           
//            fontMapper.put("隶书", PhysicalFonts.get("LiSu"));
// 	        fontMapper.put("宋体",PhysicalFonts.get("SimSun"));
// 	        fontMapper.put("微软雅黑",PhysicalFonts.get("Microsoft Yahei"));
// 	        fontMapper.put("黑体",PhysicalFonts.get("simhei"));
// 	        fontMapper.put("楷体",PhysicalFonts.get("KaiTi"));
// 	        fontMapper.put("新宋体",PhysicalFonts.get("NSimSun"));
// 	        fontMapper.put("华文行楷", PhysicalFonts.get("STXingkai"));
// 	        fontMapper.put("华文仿宋", PhysicalFonts.get("STFangsong"));
// 	        fontMapper.put("宋体扩展",PhysicalFonts.get("simsun-extB"));
// 	        fontMapper.put("仿宋",PhysicalFonts.get("FangSong"));
// 	        fontMapper.put("仿宋_GB2312",PhysicalFonts.get("FangSong_GB2312"));
// 	        fontMapper.put("幼圆",PhysicalFonts.get("YouYuan"));
// 	        fontMapper.put("华文宋体",PhysicalFonts.get("STSong"));
// 	        fontMapper.put("华文中宋",PhysicalFonts.get("STZhongsong"));	
// 	        wordMLPackage.setFontMapper(fontMapper);
// 	        RFonts rfonts = Context.getWmlObjectFactory().createRFonts(); //设置文件默认字体 	       
// 	        rfonts.setAscii("Times New Roman");
// 	        rfonts.setHAnsi("Times New Roman");
// 	        rfonts.setEastAsia("微软雅黑"); 
// 	        MainDocumentPart  mainPart=wordMLPackage.getMainDocumentPart();  
// 	        mainPart.getPropertyResolver().getDocumentDefaultRPr().setRFonts(rfonts); 
 	        processing(); 
 	       FOSettings foSettings = Docx4J.createFOSettings();  
 	       foSettings.setWmlPackage(wordMLPackage);  
 	       Docx4J.toFO(foSettings, outStream, Docx4J.FLAG_EXPORT_PREFER_XSL);
		   //Docx4J.toPDF(wordMLPackage, outStream); 	 
		    finished(); 
	}
	protected WordprocessingMLPackage getMLPackage(InputStream iStream) throws Exception{ 
			//PrintStream originalStdout = System.out; 			 
			//Disable stdout temporarily as Doc convert produces alot of output 
		 		/*System.setOut(new PrintStream(new OutputStream() { 
				public void write(int b) { 
	 				//DO NOTHING 
				} 
				}));*/ 		 
				WordprocessingMLPackage mlPackage = Doc.convert(iStream); 			 
		       // System.setOut(originalStdout); 
				return mlPackage; 
			} 
}
