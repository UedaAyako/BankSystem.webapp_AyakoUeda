package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BankController {

	private final BankAccount account = new BankAccount();

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestParam String id, @RequestParam String pw) {
		try {
			account.authenticate(id, pw);
			return ResponseEntity.ok("ログイン成功");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/deposit")
	public ResponseEntity<String> deposit(@RequestParam int amount) {
		try {
			account.deposit(amount);
			return ResponseEntity.ok("入金成功: 現在の残高は " + account.getBalance() + "円");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping("/withdraw")
	public ResponseEntity<String> withdraw(@RequestParam int amount) {
		try {
			account.withdraw(amount);
			return ResponseEntity.ok("出金成功: 現在の残高は " + account.getBalance() + "円");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/balance")
    public ResponseEntity<String> balance() {
    	return ResponseEntity.ok("現在の残高" + account.getBalance() + "円");
	}

}
