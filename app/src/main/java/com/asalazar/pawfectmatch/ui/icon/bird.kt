package com.asalazar.pawfectmatch.ui.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val bird: ImageVector
    get() {
        if (_bird != null) return _bird!!
        
        _bird = ImageVector.Builder(
            name = "bird",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                stroke = SolidColor(Color(0xFF000000)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(10.2032f, 17.5199f)
                curveTo(13.6536f, 19.1493f, 18.2452f, 18.1321f, 19.816f, 14.8541f)
                curveTo(20.9276f, 12.5342f, 17.4452f, 10.6861f, 15.6676f, 11.107f)
                curveTo(14.326f, 11.4247f, 13.5276f, 13.1588f, 12.6622f, 12.515f)
                curveTo(11.9966f, 10.0757f, 10.8166f, 6.90495f, 6.26531f, 6.06986f)
                curveTo(4.78115f, 5.7976f, 2.63169f, 6.2948f, 3.95435f, 8.02654f)
                curveTo(4.95031f, 9.33015f, 6.4178f, 9.96417f, 7.90062f, 10.6371f)
                curveTo(8.34726f, 10.8399f, 8.69809f, 11.3302f, 9.17645f, 11.4594f)
                curveTo(9.29025f, 11.4901f, 9.53769f, 11.4104f, 9.52419f, 11.5248f)
                curveTo(9.49465f, 11.7702f, 4.76764f, 9.41345f, 4.36152f, 11.0314f)
                curveTo(4.06822f, 12.1999f, 7.47748f, 12.8688f, 8.19962f, 13.0042f)
                curveTo(8.24499f, 13.0127f, 8.55151f, 13.0321f, 8.54694f, 13.0695f)
                curveTo(8.52303f, 13.2702f, 5.82951f, 12.8108f, 5.37598f, 13.7574f)
                curveTo(4.76947f, 15.0226f, 7.03739f, 15.1313f, 7.73569f, 15.0593f)
                curveTo(8.31926f, 14.999f, 8.91114f, 14.9832f, 9.47946f, 14.8794f)
                curveTo(9.49824f, 14.8761f, 10.4124f, 14.7803f, 8.65941f, 15.1086f)
                curveTo(7.10709f, 15.3993f, 3.1203f, 16.1395f, 3.01382f, 16.7401f)
                curveTo(2.90735f, 17.3407f, 3.44161f, 17.5102f, 3.73905f, 18.0518f)
                curveTo(4.0365f, 18.5934f, 4.24863f, 18.7015f, 4.55945f, 18.9801f)
                curveTo(4.87019f, 19.2586f, 6.79712f, 16.5098f, 8.85783f, 17.1823f)
                moveTo(19.5044f, 12.4399f)
                curveTo(21.2422f, 13.1108f, 21.5562f, 12.4007f, 19.9657f, 13.3573f)
                moveTo(17.2944f, 13.1301f)
                curveTo(17.2792f, 13.0891f, 17.2638f, 13.0479f, 17.2485f, 13.0068f)
            }
        }.build()
        
        return _bird!!
    }

private var _bird: ImageVector? = null

