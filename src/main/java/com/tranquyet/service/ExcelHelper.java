package com.tranquyet.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tranquyet.dto.StepDTO;
import com.tranquyet.dto.TestCaseDTO;

public class ExcelHelper {

	private static final Integer START_ROW = 3;

	private static List<StepDTO> steps = new ArrayList<>();
	private static List<TestCaseDTO> tests = new ArrayList<>();

	public static List<TestCaseDTO> initializeData(String path) {
		try {
			FileInputStream excelFile = new FileInputStream(new File(path));

			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			Integer maxRows = datatypeSheet.getPhysicalNumberOfRows();
			Iterator<Row> iterator = datatypeSheet.iterator();
			int rowNumber = 0;

			while (iterator.hasNext()) {
				int cellIdx = 0;
				Row currentRow = iterator.next();
				Iterator<Cell> cellIterator = currentRow.iterator();
				TestCaseDTO testCase = new TestCaseDTO();
				StepDTO step = new StepDTO();
				rowNumber++;
				// start row
				if (rowNumber < START_ROW) {
					continue;
				}
				// stop
				if (rowNumber == maxRows - 1) {
					break;
				}

				while (cellIterator.hasNext()) {
					Double.valueOf(1.0).longValue();
					Cell currentCell = cellIterator.next();
					switch (cellIdx) {
					case 0 -> {
						// check null value of id
						if (evalDataType(currentCell) != null) {
							Long val = Double.valueOf(evalDataType(currentCell)).longValue();
							testCase.setId(val);
						}

						break;
					}
					case 1 -> {
						testCase.setTitle(evalDataType(currentCell));
						break;
					}
					case 2 -> {
						testCase.setCategory(evalDataType(currentCell));
						break;
					}
					case 3 -> {
						testCase.setPreCondition(evalDataType(currentCell));
						break;
					}
					case 4 -> {
						if (evalDataType(currentCell) != null) {
							Long val = Double.valueOf(evalDataType(currentCell)).longValue();
							step.setStepId(val);
						}

						break;
					}
					case 5 -> {
						step.setAction(evalDataType(currentCell));
						break;
					}
					case 6 -> {
						step.setLocator(evalDataType(currentCell));
						break;
					}
					case 7 -> {
						step.setData(evalDataType(currentCell));
						break;
					}
					case 8 -> {
						step.setDescription(evalDataType(currentCell));
						break;
					}
					case 9 -> {
						testCase.setExpectedResult(evalDataType(currentCell));
						break;
					}
					default -> throw new IllegalArgumentException("Unexpected value");
					}
					cellIdx++;
				}
				// only get obj != null
				if (testCase.getId() != null) {
					tests.add(testCase);
				}

				if (step.getStepId() != null) {
					steps.add(step);
				}

			}
			List<TestCaseDTO> cases = mappingTestStep(tests, steps);
			return cases;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static List<TestCaseDTO> mappingTestStep(List<TestCaseDTO> tests, List<StepDTO> steps) {
		List<List<StepDTO>> mappingTest = new ArrayList<>();
		// filter all index of obj.id = 1
		List<Integer> arrIdx = IntStream.range(0, steps.size()).filter(idx -> steps.get(idx)
				.getStepId().equals(1L)).map(Integer::valueOf).boxed().collect(Collectors.toList());
		// sublist steps to mapping test case
		Integer lenArrIdx = arrIdx.size() -1;
		IntStream.range(0, lenArrIdx+1).forEach(p->{
			Integer temp = p+1;
			if(p ==(lenArrIdx)) {
				mappingTest.add(steps.subList(arrIdx.get(p), steps.size()));
			}else {
				mappingTest.add(steps.subList(arrIdx.get(p), arrIdx.get(temp)));
			}
		});
		
		int length = mappingTest.size();
		// mapping test case with steps
		IntStream.range(0, length).forEach(idx -> {
			tests.get(idx)
					.setSteps(mappingTest.get(idx).stream().sorted(Comparator.comparing(StepDTO::getStepId)).toList());
		});
		return tests;
	}

	public static String evalDataType(Cell cell) {
		CellType type = cell.getCellType();
		switch (type) {
		case STRING -> {
			return cell.getStringCellValue();
		}
		case NUMERIC -> {
			String val = cell.getNumericCellValue() + "";
			return val;
		}
		case BLANK -> {
			return null;
		}
		default -> throw new IllegalArgumentException("Unexpected value");
		}
	}

}