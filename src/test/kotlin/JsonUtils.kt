import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.core.io.ClassPathResource

inline fun <reified T> ObjectMapper.readJsonAs(path: String): T {
    val resource = ClassPathResource(path)
    val json = resource.inputStream.bufferedReader().use { it.readText() }
    return this.readValue(json, T::class.java)
}
