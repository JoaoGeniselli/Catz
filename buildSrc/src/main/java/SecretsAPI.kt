import org.gradle.api.Project
import java.io.FileInputStream
import java.util.*

class SecretsAPI private constructor(
    private val secretProperties: Properties
) {
    fun getString(key: String): String = secretProperties[key] as String
    fun getBoolean(key: String): Boolean = secretProperties[key] as Boolean
    fun getInt(key: String): Int = secretProperties[key] as Int

    companion object {
        private const val SECRET_PROPERTIES_FILENAME = "secret.properties"

        fun forProject(project: Project): SecretsAPI {
            val secretPropertiesFile = project.file(SECRET_PROPERTIES_FILENAME)
            val secretProperties = Properties()
            secretProperties.load(FileInputStream(secretPropertiesFile))
            return SecretsAPI(secretProperties)
        }
    }
}