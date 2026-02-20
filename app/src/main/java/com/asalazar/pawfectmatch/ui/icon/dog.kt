package com.asalazar.pawfectmatch.ui.icon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val dog: ImageVector
    get() {
        if (_dog != null) return _dog!!
        
        _dog = ImageVector.Builder(
            name = "dog",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(3.15452f, 1.01195f)
                curveTo(5.11987f, 1.32041f, 7.17569f, 2.2474f, 8.72607f, 3.49603f)
                curveTo(9.75381f, 3.17407f, 10.8558f, 2.99995f, 12f, 2.99995f)
                curveTo(13.1519f, 2.99995f, 14.261f, 3.17641f, 15.2946f, 3.5025f)
                curveTo(16.882f, 2.27488f, 18.8427f, 1.31337f, 20.8354f, 1.01339f)
                curveTo(21.2596f, 0.950922f, 21.7008f, 1.16534f, 21.8945f, 1.55273f)
                curveTo(22.6719f, 3.38958f, 22.6983f, 5.57987f, 22.2202f, 7.49248f)
                lineTo(22.2128f, 7.52213f)
                curveTo(22.0847f, 8.03536f, 21.9191f, 8.69868f, 21.3876f, 8.92182f)
                curveTo(21.7827f, 9.89315f, 22f, 10.9466f, 22f, 12.0526f)
                curveTo(22f, 14.825f, 20.8618f, 17.6774f, 19.8412f, 20.2348f)
                lineTo(19.7379f, 20.4936f)
                curveTo(19.1182f, 22.0486f, 17.7316f, 23.1196f, 16.125f, 23.418f)
                lineTo(13.8549f, 23.8397f)
                curveTo(13.1549f, 23.9697f, 12.4562f, 23.7172f, 12f, 23.2082f)
                curveTo(11.5438f, 23.7172f, 10.8452f, 23.9697f, 10.1452f, 23.8397f)
                lineTo(7.87506f, 23.418f)
                curveTo(6.26852f, 23.1196f, 4.88189f, 22.0486f, 4.26214f, 20.4936f)
                lineTo(4.15891f, 20.2348f)
                curveTo(3.13833f, 17.6774f, 2.00004f, 14.825f, 2.00004f, 12.0526f)
                curveTo(2.00004f, 10.9466f, 2.21737f, 9.89315f, 2.6125f, 8.92182f)
                curveTo(2.08046f, 8.69845f, 1.91916f, 8.05124f, 1.7909f, 7.53658f)
                lineTo(1.7799f, 7.49248f)
                curveTo(1.32311f, 5.66527f, 1.23531f, 3.2968f, 2.10561f, 1.55273f)
                curveTo(2.29827f, 1.16741f, 2.72906f, 0.945857f, 3.15452f, 1.01195f)
                close()
                moveTo(6.58478f, 4.44052f)
                curveTo(5.45516f, 5.10067f, 4.47474f, 5.9652f, 3.71373f, 6.98132f)
                curveTo(3.41572f, 5.76461f, 3.41236f, 4.41153f, 3.67496f, 3.18754f)
                curveTo(4.68842f, 3.48029f, 5.68018f, 3.89536f, 6.58478f, 4.44052f)
                close()
                moveTo(20.2863f, 6.98133f)
                curveTo(19.5303f, 5.97184f, 18.5577f, 5.11195f, 17.4374f, 4.45347f)
                curveTo(18.3364f, 3.9005f, 19.3043f, 3.45749f, 20.3223f, 3.17455f)
                curveTo(20.5884f, 4.40199f, 20.5853f, 5.76068f, 20.2863f, 6.98133f)
                close()
                moveTo(8.85364f, 5.56694f)
                curveTo(9.81678f, 5.20285f, 10.8797f, 4.99995f, 12f, 4.99995f)
                curveTo(13.1204f, 4.99995f, 14.1833f, 5.20285f, 15.1464f, 5.56694f)
                curveTo(18.0554f, 6.66661f, 20f, 9.1982f, 20f, 12.0526f)
                curveTo(20f, 14.4676f, 18.9891f, 16.9876f, 18.0863f, 19.238f)
                curveTo(18.0168f, 19.4113f, 17.9478f, 19.5832f, 17.8801f, 19.7531f)
                curveTo(17.5291f, 20.6338f, 16.731f, 21.2712f, 15.7597f, 21.4516f)
                lineTo(13.4896f, 21.8733f)
                lineTo(12.912f, 20.5896f)
                curveTo(12.7505f, 20.2307f, 12.3935f, 19.9999f, 12f, 19.9999f)
                curveTo(11.6065f, 19.9999f, 11.2496f, 20.2307f, 11.0881f, 20.5896f)
                lineTo(10.5104f, 21.8733f)
                lineTo(8.24033f, 21.4516f)
                curveTo(7.26908f, 21.2712f, 6.471f, 20.6338f, 6.12001f, 19.7531f)
                curveTo(6.05237f, 19.5834f, 5.98357f, 19.4119f, 5.91414f, 19.2388f)
                curveTo(5.01135f, 16.9884f, 4.00004f, 14.4676f, 4.00004f, 12.0526f)
                curveTo(4.00004f, 9.1982f, 5.94472f, 6.66661f, 8.85364f, 5.56694f)
                close()
                moveTo(10.5f, 15.9999f)
                curveTo(10.1212f, 15.9999f, 9.77497f, 16.2139f, 9.60557f, 16.5527f)
                curveTo(9.43618f, 16.8915f, 9.47274f, 17.2969f, 9.7f, 17.5999f)
                lineTo(11.2f, 19.5999f)
                curveTo(11.3889f, 19.8517f, 11.6852f, 19.9999f, 12f, 19.9999f)
                curveTo(12.3148f, 19.9999f, 12.6111f, 19.8517f, 12.8f, 19.5999f)
                lineTo(14.3f, 17.5999f)
                curveTo(14.5273f, 17.2969f, 14.5638f, 16.8915f, 14.3944f, 16.5527f)
                curveTo(14.225f, 16.2139f, 13.8788f, 15.9999f, 13.5f, 15.9999f)
                horizontalLineTo(10.5f)
                close()
                moveTo(9.62134f, 11.1212f)
                curveTo(9.62134f, 11.9497f, 8.94977f, 12.6212f, 8.12134f, 12.6212f)
                curveTo(7.29291f, 12.6212f, 6.62134f, 11.9497f, 6.62134f, 11.1212f)
                curveTo(6.62134f, 10.2928f, 7.29291f, 9.62125f, 8.12134f, 9.62125f)
                curveTo(8.94977f, 9.62125f, 9.62134f, 10.2928f, 9.62134f, 11.1212f)
                close()
                moveTo(16f, 12.4999f)
                curveTo(16.8284f, 12.4999f, 17.5f, 11.8284f, 17.5f, 10.9999f)
                curveTo(17.5f, 10.1715f, 16.8284f, 9.49994f, 16f, 9.49994f)
                curveTo(15.1716f, 9.49994f, 14.5f, 10.1715f, 14.5f, 10.9999f)
                curveTo(14.5f, 11.8284f, 15.1716f, 12.4999f, 16f, 12.4999f)
                close()
            }
        }.build()
        
        return _dog!!
    }

private var _dog: ImageVector? = null

