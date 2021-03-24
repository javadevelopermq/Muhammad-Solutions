package com.portal.palindrome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portal.palindrome.dao.PalindromeRepository;
import com.portal.palindrome.util.PalindromeUtil;

@RestController
public class PalindromeController {

	@Autowired
	private PalindromeRepository repo;

	@Autowired
	private PalindromeUtil palindromUtil;

	@PostMapping(value = "/palindrome/{key}", produces = "application/json")
	public ResponseEntity<String> insertJob(@PathVariable("key") String key) {
		int result = 2;
		try {
			String pal = palindromUtil.getLongPal(key);
			result = repo.insert(result, key, pal);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result > 0) {
			return new ResponseEntity<String>("palindrome string stored successfully", HttpStatus.OK);
		} else {

			return new ResponseEntity<String>("Failed to insert palindrome string", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/palindrome", produces = "application/json")
	public ResponseEntity<String> get(@RequestParam("key") String key) {
		String result = null;
		try {
			result = repo.findByKey(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result != null) {
			return new ResponseEntity<>("Largest palindrome string for " + key + " is: " + result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Key not found", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
