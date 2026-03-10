data class Profile(
    val name: String,
    val title: String,
    val bio: String
)

fun renderAvatar(width: Int, height: Int): String {
    if (width < 4 || height < 3) 
    return "[avatar]"

  val topBottom = "+" + "-".repeat(width - 2) + "+\n"
  val emptyLine = "|" + " ".repeat(width - 2) + "|\n"

    val label = "Avatar"
    val innerWidth = width - 2
    val leftPadding = ((innerWidth - label.length) / 2).coerceAtLeast(0)
    val rightPadding = (innerWidth - label.length - leftPadding).coerceAtLeast(0)
    val labelLine = "|" +
    " ".repeat(leftPadding) +
    label.take(innerWidth) + " ".repeat(rightPadding) + "|\n"

    return buildString {
        append(topBottom)
        val remainingLines = height - 2
        if (remainingLines <= 1) {
            append(labelLine)
        } else {
            val linesAbove = (remainingLines - 1) / 2
            val linesBelow = remainingLines - 1 - linesAbove
            repeat(linesAbove) { append(emptyLine) }
            append(labelLine)
            repeat(linesBelow) { append(emptyLine) }
        }
        append(topBottom)
    }
}

fun renderTextBlock(label: String, text: String, width: Int): String {
  val innerWidth = width - 2
  val full = "$label: $text"
  val shown = if (full.length > innerWidth) {
        full.take(innerWidth - 3) + "..."
    } else {
        full
    }
    val padding = innerWidth - shown.length
    return "|" + shown + " ".repeat(padding.coerceAtLeast(0)) + "|\n"
}
fun renderProfile(profile: Profile, width: Int = 30, showAvatar: Boolean = true): String {
    val topBottom = "+" + "-".repeat(width - 2) + "+\n"
    val spacer = "|" + " ".repeat(width - 2) + "|\n"

    return buildString {
        append(topBottom)

        if (showAvatar) {
            val avatar = renderAvatar(width - 2, height = 3)
                .lines()
                .filter { it.isNotBlank() }
            for (line in avatar) {
                val inner = line.trimEnd('\n')
                val pad = (width - 2 - inner.length).coerceAtLeast(0)
                append("|")
                append(inner)
                append(" ".repeat(pad))
                append("|\n")
            }
            append(spacer)
        }

        append(renderTextBlock("Name", profile.name, width))
        append(renderTextBlock("Title", profile.title, width))
        append(renderTextBlock("Bio", profile.bio, width))

        append(topBottom)
    }
}

fun main() {
    val p1 = Profile(
        name = "Ada Lovelace",
        title = "Software Developer",
        bio = "Early computing"
    )

    val p2 = Profile(
        name = "Lewis",
        title = "Mathematician",
        bio = "Laid foundations of computer science"
    )

    val p3 = Profile(
        name = "Neha Shetty",
        title = "Software Engineer",
        bio = "CEO"
    )

    println(renderProfile(p1, width = 30, showAvatar = true))
    println()
    println(renderProfile(p2, width = 30, showAvatar = false))
    println()
    println(renderProfile(p3, width = 30, showAvatar = true))
}
