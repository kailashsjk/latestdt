/*package com.techm.adms.dt.web;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;


@Path("upload")
public class MediaUploadService {
	
	// path to upload a file
	private final String UPLOADED_FILE_PATH = "E:\\temp\\";	
	//private final String UPLOADED_FILE_PATH = "D:\\ADMS\\temp\\";
	
	// path to upload the generated reports
	private static final String UPLOADED_REPORTS_FILE_PATH = "D:\\programs\\servers\\tomcat\\apache-tomcat-7.0.26\\webapps\\windup-reports\\";	
	
	private static final String WINDUP_PATH = "D:/programs/tools/windup-distribution-2.4.1.Final/bin";
	
	private static final String REPORT_LINK = "http://localhost:8080/windup-reports/";
	
	private Connection connection;
	
	
	@Path("/file")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String uploadFile(MultipartFormDataInput input) throws IOException {
		
		String response = null;
        String fileName = "";
        InputPart part = null;
        Map<String, List<InputPart>> uploadForm = null;
        @SuppressWarnings("unused")
        MultivaluedMap<String, String> header = null;
        String[] contentDispositionHeader = null;
        
        if (input != null) {
    		//Get API input data
            uploadForm = input.getFormDataMap();        	
        }
		
        if (uploadForm != null && !uploadForm.isEmpty()) {        	
        	part = uploadForm.get("file").get(0);
        }
        
        try {
        	if (part != null) {
                //Use this header for extra processing if required
            	header = part.getHeaders();            
                //System.out.println("header... " + header);        		
        	
	        	if (header != null) {
	                contentDispositionHeader = header.getFirst("Content-Disposition").split(";");
	                for (String name : contentDispositionHeader) {
	                	if (name.contains("filename")) {
	                		StringTokenizer st = new StringTokenizer(name, "=");
	                		int iteration = 0;
	                		while (st != null && st.hasMoreTokens()) {
	                			iteration++;
	                			String key = st.nextToken();
	                			if (iteration == 2) {
	                				fileName = key.substring(1, key.lastIndexOf('"'));
	                				System.out.println("key... " + fileName);
	                			}
	                		}
	                		break;
	                	}
	                }        		
	        	}
            
	            // convert the uploaded file to inputstream
	            InputStream inputStream = part.getBody(InputStream.class, null);
	             
	            byte[] bytes = IOUtils.toByteArray(inputStream);
	            // constructs upload file path
	            String fullFilePath = UPLOADED_FILE_PATH + fileName;
	            response = writeFile(bytes, fullFilePath, fileName);
	            System.out.println("Success !!!!!");
	            
	            String reportLink = REPORT_LINK + fileName + "-report/index.html";
	            
	            addReportDetails(fileName, reportLink);
	            	            
        	}
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }        
        return response;
    }
 
    //Utility method
    private String writeFile(byte[] content, String fullFilePath, String filename) throws IOException
    {
    	String response = null;
    	System.out.println("filename.... " + filename);
    	System.out.println("fullFilePath.... " + fullFilePath);
    	
        File file = new File(fullFilePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fop = new FileOutputStream(file);
        fop.write(content);
        fop.flush();
        fop.close();
        
        executeBatch(filename);
        response = "File successfully uploaded...," + filename;
        return response;
        
    }
    
    private void executeBatch(String filename) {
    	System.out.println("filename in executebatch.... " + filename);
    	String savePath = "";
    	String batFile = "";
    	
    	 savePath = "E:\\temp";    	
    	//savePath = "D:\\ADMS\\temp";
    	
    	//String batFile = "cmd /c start D:/ADMS/installed/windup-distribution-2.4.1.Final/bin/migrate.bat";
    	
    	// create a batch file and store it in the defined path
    	batFile = "cmd /c start E:/temp/migrate.bat";
    	//batFile = "cmd /c start D:/ADMS/temp/migrate.bat";
    	
    	try {
			// For tomcat
			//String pathname = "D:/programs/tools/windup-distribution-2.4.1.Final/bin";			
			// For jboss
			//String pathname = "D:/ADMS/installed/windup-distribution-2.4.1.Final/bin";
    		
    		String pathname = WINDUP_PATH;
			File file = new File(savePath + "/migrate.bat");
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			StringBuffer content = new StringBuffer();
			//content.append("set path=%path%;D:\\programs\\tools\\windup-distribution-2.4.1.Final\\bin");
			content.append("set path=%path%;" + pathname);
			content.append("\n");
			content.append("windup --input " + savePath + "\\" + filename);
			content.append(" --output " + UPLOADED_REPORTS_FILE_PATH + filename + "-report  --target eap --packages com --overwrite");
			bw.write(content.toString());
			bw.close();
			
            Process p = Runtime.getRuntime().exec(batFile);
            
            System.out.println("Waiting till the thread is completed...");
            
            //Thread.sleep(1000*60*2);
            Thread.sleep(1000*60*2);
            
            //addDirectoryToZip(UPLOADED_REPORTS_FILE_PATH + filename + "-report");
            
            //System.out.println("Successfully zipped....");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void addDirectoryToZip(String directory) {
    	
    	System.out.println("addDirectoryToZip inside...");
    	
    	try {
        	File directoryToZip = new File(directory);

    		List<File> fileList = new ArrayList<File>();
    		System.out.println("---Getting references to all files in: " + directoryToZip.getCanonicalPath());
    		ZipDirectory.getAllFiles(directoryToZip, fileList);
    		System.out.println("---Creating zip file");
    		ZipDirectory.writeZipFile(directoryToZip, fileList);
    		System.out.println("---Done");    		
    	} catch(Exception e) {
    		 e.printStackTrace();
    	}
    }
    
    private void addReportDetails(String filename, String reportLink) {
    	Statement statement = null;
    	System.out.println("UploadService...addReportDetails...start");
    	try {
    		connection = WindupConnection.getConnection();
    		statement = connection.createStatement();
    		String sql = "INSERT INTO WINDUP_REPORT (REPORT_NAME, REPORT_LINK) VALUES ('" + filename + "','" + reportLink + "')";
    		int count = statement.executeUpdate(sql);
    		if (count > 0) {
    			System.out.println("Record inserted successfully.");
    		}
    	} catch(Exception e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			if (statement != null) {
    				statement.close();
    			}
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	System.out.println("UploadService...addReportDetails...end");
    }    
}

*/