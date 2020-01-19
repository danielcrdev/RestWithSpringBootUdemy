package br.com.danielcrdev.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielcrdev.exception.UnsuportedMathOperationException;

@RestController
public class MathController {
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
	}

	@RequestMapping(value="/subtract/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtract(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		Double subtract = convertToDouble(numberOne) - convertToDouble(numberTwo);
		return subtract;
	}
	
	@RequestMapping(value="/multiply/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiply(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		Double multiply = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return multiply;
	}

	@RequestMapping(value="/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		Double division = convertToDouble(numberOne) / convertToDouble(numberTwo);
		return division;
	}
	
	@RequestMapping(value="/average/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		Double average = division( Double.toString(sum(numberOne, numberTwo)), "2");
		return average;
	}
	
	@RequestMapping(value="/squareRoot/{numberOne}", method = RequestMethod.GET)
	public Double squareRoot(@PathVariable("numberOne") String numberOne) throws Exception {
		if (!isNumeric(numberOne)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		Double squareRoot = Math.sqrt(convertToDouble(numberOne));
		return squareRoot;
	}
	
	private Double convertToDouble(String strNumber) {
		if (strNumber == null)  {
			return 0D;
		}
		String number = strNumber.replaceAll(",", ".");
		if (isNumeric(number)) {
			return Double.parseDouble(number);
		}
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null) return false;
		String number = strNumber.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
