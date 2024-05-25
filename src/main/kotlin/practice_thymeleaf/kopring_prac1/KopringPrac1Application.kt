package practice_thymeleaf.kopring_prac1

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@SpringBootApplication
class KopringPrac1Application

fun main(args: Array<String>) {
	runApplication<KopringPrac1Application>(*args)
}

@Controller
class TestClass {

	@GetMapping("test")
	fun test(model: Model): String {

		model.addAttribute("data", " TEST !! ")

		return "test"
	}

	@GetMapping("test-mvc")
	fun test2(@RequestParam(value = "name") name: String ,model: Model): String {
		model.addAttribute("name", name)

		return "test-mvc"
	}
}