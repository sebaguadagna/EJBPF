package com.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Encrypt {

	private String passToHash;
	
	public Md5Encrypt(String passwd) {
		
		this.passToHash = passwd;
		
	}

	public String getPassToHash() {
		return passToHash;
	}

	public void setPassToHash(String passToHash) {
		this.passToHash = passToHash;
	}
	
	public String getEncryptedPass() throws NoSuchAlgorithmException {
		
		MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(this.passToHash.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
		return sb.toString();
		
	}
}
