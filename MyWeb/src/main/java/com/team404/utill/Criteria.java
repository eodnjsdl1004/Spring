package com.team404.utill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Criteria {	
	private int pageNum;
	private int amount;
	
	public Criteria() {
		this(1,10);
	}
}
