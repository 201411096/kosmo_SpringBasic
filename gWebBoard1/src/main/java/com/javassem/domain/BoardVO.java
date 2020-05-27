package com.javassem.domain;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class BoardVO {
	private int b_id;
	private String b_name;
	private String b_email;
	private String b_title;
	private String b_content;
	private String b_pwd;
	private String b_date;	
	private int b_count;
	private String b_ip;
	private String b_fname;
	private long b_fsize;
	
	//*************************************************
	MultipartFile file; // (****) file 변수명이 폼에 name과 같아야함 <input type='file' name=''>
	
	public MultipartFile getFile() {
		return file;
	}
	// FileUpload setters 설정
	public void setFile(MultipartFile file) {
		this.file = file;
		
		if(!file.isEmpty()) {
			// MultipartFile에서 파일명과 크기만 얻어오기 -> DB에 입력
			this.b_fname = file.getOriginalFilename();
			this.b_fsize = file.getSize();
			
			// 실제 파일로 저장
			File f = new File("D:\\SpringBasic\\gWebBoard1\\src\\main\\webapp\\resources\\upload\\" + b_fname);
			try {
				file.transferTo(f);	// 사용자가 입력해둔 파일을 내가 만들어둔 file 객체에 보냄
			} catch (Exception e) {
				System.out.println("파일전송 실패 : " + e.getMessage());
				e.printStackTrace();
			}
		}
			
	}
	public int getB_id() {
		return b_id;
	}
	public void setB_id(int b_id) {
		this.b_id = b_id;
	}
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_email() {
		return b_email;
	}
	public void setB_email(String b_email) {
		this.b_email = b_email;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_pwd() {
		return b_pwd;
	}
	public void setB_pwd(String b_pwd) {
		this.b_pwd = b_pwd;
	}
	public String getB_date() {
		return b_date;
	}
	public void setB_date(String b_date) {
		this.b_date = b_date;
	}
	public int getB_count() {
		return b_count;
	}
	public void setB_count(int b_count) {
		this.b_count = b_count;
	}
	public String getB_ip() {
		return b_ip;
	}
	public void setB_ip(String b_ip) {
		this.b_ip = b_ip;
	}
	public String getB_fname() {
		return b_fname;
	}
	public void setB_fname(String b_fname) {
		this.b_fname = b_fname;
	}
	public long getB_fsize() {
		return b_fsize;
	}
	public void setB_fsize(long b_fsize) {
		this.b_fsize = b_fsize;
	}

	

}
