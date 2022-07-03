package com.tranquyet.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class BasedDTO<T> {

	private Long id;

	private Long[] ids;

	private List<T> listResult = new ArrayList<T>();

	private String alert;

	private String type;

}
