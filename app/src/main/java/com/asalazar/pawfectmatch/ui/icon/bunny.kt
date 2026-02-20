package com.asalazar.pawfectmatch.ui.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val bunny: ImageVector
    get() {
        if (_bunny != null) return _bunny!!
        
        _bunny = ImageVector.Builder(
            name = "bunny",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 2f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(8.31273f, 11.9751f)
                curveTo(7.75257f, 11.122f, 7.44423f, 10.1197f, 6.94167f, 9.22269f)
                curveTo(6.50445f, 8.44281f, 4.9019f, 3.30594f, 7.08837f, 3.61948f)
                curveTo(9.17139f, 3.91831f, 10.038f, 7.45185f, 10.4186f, 9.07521f)
                curveTo(10.638f, 10.0114f, 10.6676f, 11.3362f, 10.7123f, 11.3362f)
                curveTo(10.7581f, 11.3362f, 11.2794f, 9.52395f, 11.349f, 9.37017f)
                curveTo(12.5217f, 6.78015f, 13.9934f, 5.04003f, 15.8543f, 3.30003f)
                curveTo(17.7152f, 1.56004f, 17.7063f, 2.52486f, 17.8619f, 2.58728f)
                curveTo(18.1967f, 2.72176f, 18.66f, 5.40002f, 16.83f, 8.34003f)
                curveTo(15f, 11.28f, 14.3754f, 11.9751f, 13.9934f, 12.614f)
                curveTo(13.8911f, 12.7851f, 15.96f, 13.92f, 15.96f, 16.2f)
                curveTo(15.96f, 18.54f, 13.9382f, 21.24f, 11.3491f, 21.24f)
                curveTo(8.75997f, 21.24f, 5.33996f, 18.6f, 6.94167f, 13.38f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(11.3667f, 17.6139f)
                curveTo(10.02f, 16.44f, 12.0272f, 16.6389f, 12.0838f, 16.8307f)
                curveTo(12.1342f, 17.0016f, 11.5039f, 17.4684f, 11.3667f, 17.6139f)
                close()
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(10.38f, 19.0146f)
                curveTo(11.215f, 19.3784f, 11.6986f, 19.3347f, 12.3564f, 18.66f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(11.379f, 17.9711f)
                curveTo(11.3876f, 18.2135f, 11.3477f, 18.4401f, 11.3202f, 18.6686f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(10.6503f, 15.1509f)
                curveTo(10.6503f, 14.9958f, 10.6503f, 14.8409f, 10.6503f, 14.6858f)
            }
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(12.1616f, 15.0496f)
                curveTo(12.1616f, 14.8898f, 12.1616f, 14.7297f, 12.1616f, 14.5696f)
            }
        }.build()
        
        return _bunny!!
    }

private var _bunny: ImageVector? = null

