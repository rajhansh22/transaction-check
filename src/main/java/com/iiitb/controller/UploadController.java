package com.iiitb.controller;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iiitb.dao.TransactionRepo;
import com.iiitb.excelParser.ExcelReader;
import com.iiitb.model.Transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UploadController {
	
	@Autowired
	TransactionRepo transactionrepo;
	
	ExcelReader er;
	
	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	
    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "/home/kishore/Documents/workspace-spring-tool-suite-4-4.1.1.RELEASE/spring-boot-file-upload-example/data/";
    
    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file
                                   ) throws InvalidFormatException, ParseException {

        if (file.isEmpty()) {
            //redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            //return "redirect:uploadStatus";
            return "redirect:/filterOption";
        }

        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            //redirectAttributes.addFlashAttribute("message",
            //        "You successfully uploaded '" + file.getOriginalFilename() + "'");
            er=new ExcelReader();
            List<Transaction> transactions=er.parse();
            for(Transaction tr:transactions) {
            	Transaction duplicate=transactionrepo.findOne(tr.getPaymentId());
            	if(duplicate==null)
            	transactionrepo.save(tr);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
        //return "redirect:/filterOption";
    }
    
    //kk
    @RequestMapping(value="/data/insert" ,method=RequestMethod.GET)
	public void insertData() {
		//pass controller to parser and then insert in repo
	}
    @PostMapping("/filter") // //new annotation since 4.3
    public void applyFiltering(@RequestParam("filters") String str) {
    	
    	//return "working";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }

}