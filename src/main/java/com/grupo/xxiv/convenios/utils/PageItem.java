package com.grupo.xxiv.convenios.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageItem {
	
	public PageItem(int numero, boolean actual) {
	this.numero = numero;
	this.actual = actual;
	}
	private int numero;
	private boolean actual;
}
