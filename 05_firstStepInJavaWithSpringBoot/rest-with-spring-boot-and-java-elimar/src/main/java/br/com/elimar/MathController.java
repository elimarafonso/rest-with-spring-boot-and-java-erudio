package br.com.elimar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.elimar.Execptions.UnsupportedMathOperationException;

@RestController
public class MathController {

	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(name = "numberOne") String numberOne,
			@PathVariable(name = "numberTwo") String numberTwo) {

		try {

			Double number1 = Double.parseDouble(numberOne);
			Double number2 = Double.parseDouble(numberTwo);
			Double soma = (number1 + number2);
			return soma;
		} catch (Exception e) {
			throw new UnsupportedMathOperationException("Valores incorretos");
		}

	}

	@GetMapping("/sub/{numberOne}/{numberTwo}")
	public String sub(@PathVariable(name = "numberOne") String numberOne,
			@PathVariable(name = "numberTwo") String numberTwo) {

		try {
			Double number1 = formataNumber(numberOne);
			Double number2 = formataNumber(numberTwo);
			String result = number1 + " - " + number2 + " = " + (number1 - number2);
			return result;

		} catch (Exception e) {
			throw new UnsupportedMathOperationException("favo inserir numeros válidos");
		}

	}

	@GetMapping("/mult/{numberOne}/{numberTwo}")
	public String mult(@PathVariable(name = "numberOne") String numberOne,
			@PathVariable(name = "numberTwo") String numberTwo) {

		try {
			Double number1 = formataNumber(numberOne);
			Double number2 = formataNumber(numberTwo);
			var result = (number1 * number2);
			String message = number1 + " X " + number2 + " = " + result;
			return message;

		} catch (Exception e) {
			throw new UnsupportedMathOperationException("favo inserir numeros válidos");
		}

	}
	
	@GetMapping("/div/{numberOne}/{numberTwo}")
	public String div(@PathVariable(name = "numberOne") String numberOne,
			@PathVariable(name = "numberTwo") String numberTwo) {

		try {
			Double number1 = formataNumber(numberOne);
			Double number2 = formataNumber(numberTwo);
			String result = number1 + " / " + number2 + " = " + (number1 / number2);
			return result;

		} catch (Exception e) {
			throw new UnsupportedMathOperationException("favo inserir numeros válidos");
		}

	}
	
	
	@GetMapping("/media/{numberOne}/{numberTwo}")
	public String media(@PathVariable(name = "numberOne") String numberOne,
			@PathVariable(name = "numberTwo") String numberTwo) {

		try {
			Double number1 = formataNumber(numberOne);
			Double number2 = formataNumber(numberTwo);
			String result =" ("+ number1 + " + " + number2 + ") / 2 = " + (number1 + number2)/2;
			return result;

		} catch (Exception e) {
			throw new UnsupportedMathOperationException("favo inserir numeros válidos");
		}

	}
	
	@GetMapping("/raiz/{numberOne}")
	public String raiz(@PathVariable(name = "numberOne") String numberOne) {

		try {
			Double number1 = formataNumber(numberOne);
			String result = number1 + " Raiz quadrada = " + Math.sqrt(number1);
			return result;

		} catch (Exception e) {
			throw new UnsupportedMathOperationException("favo inserir numeros válidos");
		}

	}
	
	
	private Double formataNumber(String numberOne) {

		numberOne = numberOne.replaceAll(",", ".");
		Double number = Double.parseDouble(numberOne);

		return number;
	}

}
