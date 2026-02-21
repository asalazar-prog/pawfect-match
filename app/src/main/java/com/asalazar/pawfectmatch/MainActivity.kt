package com.asalazar.pawfectmatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Cake
import androidx.compose.material.icons.rounded.SearchOff
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asalazar.pawfectmatch.data.PetDataSource
import com.asalazar.pawfectmatch.model.AnimalNature
import com.asalazar.pawfectmatch.model.Gender
import com.asalazar.pawfectmatch.model.Pet
import com.asalazar.pawfectmatch.model.Species
import com.asalazar.pawfectmatch.ui.icon.footprint
import com.asalazar.pawfectmatch.ui.theme.PawfectMatchTheme


/**
 *
 * NOTA PARA EL EVALUADOR:
 * Por requerimientos de la prueba técnica, todo el código composable se presenta en este archivo.
 * Sin embargo, bajo una arquitectura profesional (MVVM/Clean), los componentes de UI,
 * modelos y DataSource estarían desacoplados en paquetes independientes (ui, model, data)
 * para mejorar la mantenibilidad y escalabilidad del proyecto.
 *
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { PawfectMatchTheme { PawfectMatchApp() } }
    }
}

@Composable
fun PawfectMatchApp() {

    val dataResource = remember { PetDataSource() }
    val allPets = dataResource.getPets()
    var searchQuery by remember { mutableStateOf("") }
    var selectedSpecies by remember { mutableStateOf<Species?>(null) }
    val urgentPet = dataResource.getUrgentPet()


    val filteredPets by remember(searchQuery, selectedSpecies) {
        derivedStateOf {
            allPets.filter { pet ->
                val matchesSearch =
                    pet.name.contains(searchQuery, ignoreCase = true) || pet.breed.contains(
                        searchQuery,
                        ignoreCase = true
                    )
                val matchesSpecies = selectedSpecies == null || pet.species == selectedSpecies
                matchesSearch && matchesSpecies
            }
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(vertical = 8.dp)
            .background(color = MaterialTheme.colorScheme.surface),
        topBar = {
            PawfectMatchTopBar(
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            item(span = { GridItemSpan(2) }) {
                MainTitleCatalog(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                )
            }

            item(span = { GridItemSpan(2) }) {
                PetSearchBar(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                )
            }

            stickyHeader {
                Surface(color = MaterialTheme.colorScheme.surface) {
                    SpeciesFilterRow(
                        selectedSpecies = selectedSpecies,
                        onSpeciesSelected = { selectedSpecies = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                }
            }

            item(span = { GridItemSpan(2) }) {
                UrgentPetView(
                    pet = urgentPet,
                    distance = dataResource.getDistanceFromUser(urgentPet.id),
                    modifier = Modifier
                        .fillMaxWidth()
                        .sectionVerticalPadding()
                )
            }

            item(span = { GridItemSpan(2) }) {
                Subtitle(
                    stringResource(R.string.tlt_recently_added),
                    modifier = Modifier.sectionVerticalPadding()
                )
            }


            if (filteredPets.isEmpty()) {
                item(span = { GridItemSpan(2) }) {
                    EmptyStatePets()
                }
            } else {
                items(filteredPets, { pet -> pet.id.toInt() }) { pet ->
                    AnimatedVisibility(
                        visible = true,
                        enter = fadeIn(animationSpec = tween(500)) + scaleIn(initialScale = 0.8f),
                        modifier = Modifier
                            .shadowEdgePadding()
                            .animateItem()
                    ) { RecentlyAddedItem(pet) }
                }
            }
        }
    }
}

@Composable
fun RecentlyAddedItem(pet: Pet, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.small,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            RecentlyAddedImage(pet.photo, pet.isSterilized)
            RecentlyAddedNameAndSpecies(pet.name, stringResource(pet.species.labelRes))

            CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.secondary) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    GenderLabel(pet.gender)
                    Text("・", color = MaterialTheme.colorScheme.tertiary)
                    AgeLabel(pet.displayAge)
                }

            }
            NatureBadgeRow(pet.nature)
        }
    }
}

@Composable
fun NatureBadgeRow(nature: List<AnimalNature>, modifier: Modifier = Modifier) {
    FlowRow(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        nature.forEach { NatureBadge(it) }
    }
}

@Composable
fun NatureBadge(nature: AnimalNature, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        color = nature.containerColor,
        contentColor = nature.contentColor,
        shape = MaterialTheme.shapes.small,
        border = BorderStroke(1.dp, nature.contentColor)
    ) {
        Text(
            text = stringResource(nature.labelRes),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}

@Composable
fun AgeLabel(months: String, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        Icon(Icons.Rounded.Cake, contentDescription = null, modifier = Modifier.size(16.dp))
        Text(months, style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
fun RecentlyAddedNameAndSpecies(name: String, species: String, modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(name, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
        Text(
            " - $species",
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.secondary,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun GenderLabel(gender: Gender, modifier: Modifier = Modifier) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        GenderIcon(gender, modifier = Modifier.size(16.dp))
        Text(stringResource(gender.labelRes), style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
fun GenderIcon(gender: Gender, modifier: Modifier = Modifier) {
    Icon(gender.icon, tint = gender.color, contentDescription = null, modifier = modifier)
}

@Composable
fun RecentlyAddedImage(
    @DrawableRes photoResource: Int,
    isSterilized: Boolean,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.clip(MaterialTheme.shapes.medium)) {
        Image(
            painterResource(photoResource),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )
        SterilizationBadge(
            isSterilized, Modifier
                .padding(8.dp)
                .align(Alignment.BottomStart)
        )
    }

}

@Composable
fun EmptyStatePets(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Icon(
            imageVector = Icons.Rounded.SearchOff,
            contentDescription = null,
            modifier = Modifier.size(80.dp),
            tint = MaterialTheme.colorScheme.outlineVariant
        )

        Text(
            text = stringResource(R.string.title_no_furry_friends_found),
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurface
        )

        Text(
            text = stringResource(R.string.lbl_empty_state),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.secondary,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 32.dp)
        )
    }
}

@Composable
fun SpeciesFilterRow(
    selectedSpecies: Species?,
    modifier: Modifier = Modifier,
    onSpeciesSelected: (Species?) -> Unit
) {
    val speciesList = listOf(null) + Species.entries

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(speciesList) { species ->
            SpeciesFilterItem(
                species = species,
                isSelected = species == selectedSpecies,
                onClick = { onSpeciesSelected(species) }
            )
        }
    }
}

@Composable
fun UrgentPetView(
    pet: Pet,
    distance: String,
    modifier: Modifier = Modifier
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp), modifier = modifier) {
        Subtitle(stringResource(R.string.tlt_urgent_pets))
        UrgentPetItem(
            pet,
            distance = distance,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.2f)
                .padding(horizontal = 6.dp)
        )
    }
}

@Composable
fun UrgentPetItem(pet: Pet, distance: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box {
            Image(
                painterResource(pet.photo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .gradientImage()
            )

            UrgentPetDetail(
                pet = pet,
                distance = distance,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.BottomStart)
            )

        }
    }
}

@Composable
fun UrgentPetDetail(pet: Pet, distance: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        CompositionLocalProvider(LocalContentColor provides Color.White) {
            UrgentPetTagsRow(pet)
            Text(
                pet.name,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )

            Text(
                "${pet.breed} • ${pet.displayAge}",
                style = MaterialTheme.typography.bodySmall,
                color = Color.White.copy(alpha = 0.8f)
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Default.LocationOn,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Text(distance, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

val Pet.displayAge: String
    get() = if (ageInMonths < 12U) "$ageInMonths mos" else "${ageInMonths / 12U} yrs"

@Composable
fun UrgentPetTagsRow(pet: Pet, modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = modifier) {
        UrgentPetTag()
        PetTag(stringResource(pet.gender.labelRes), color = MaterialTheme.colorScheme.secondary)
    }
}

@Composable
fun UrgentPetTag(modifier: Modifier = Modifier) {
    PetTag(
        text = stringResource(R.string.lbl_urgent),
        modifier = modifier,
        color = MaterialTheme.colorScheme.primary
    )
}

@Composable
fun PetTag(text: String, color: Color = Color.Unspecified, modifier: Modifier = Modifier) {
    Surface(modifier = modifier, color = color, shape = MaterialTheme.shapes.small) {
        Text(
            text,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

@Composable
fun SterilizationBadge(isSterilized: Boolean, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        color = if (isSterilized) Color(0xFFE8F5E9) else Color(0xFFF5F5F5),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = if (isSterilized) stringResource(R.string.lbl_sterilized) else stringResource(R.string.lbl_intact),
            color = if (isSterilized) Color(0xFF2E7D32) else Color(0xFF757575),
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

@Composable
fun Subtitle(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        modifier = modifier,
        style = MaterialTheme.typography.headlineSmall,
        fontWeight = FontWeight.SemiBold
    )
}

@Composable
fun SpeciesFilterItem(
    species: Species?,
    isSelected: Boolean = false,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            onClick,
            color = if (isSelected) MaterialTheme.colorScheme.primary else Color.White,
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier.size(60.dp)
        ) {
            Icon(
                species?.icon ?: footprint,
                contentDescription = null,
                modifier = Modifier.padding(10.dp)
            )
        }
        Text(species?.labelRes?.let { stringResource(it) } ?: stringResource(R.string.lbl_all),
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
fun PetSearchBar(
    value: String,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        modifier = modifier,
        onValueChange = onValueChange,
        shape = MaterialTheme.shapes.medium,
        singleLine = true,
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.outlineVariant,
        ),
        placeholder = {
            Text(
                text = stringResource(R.string.lbl_search_breed_or_name),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    )
}

@Composable
fun PawfectMatchTopBar(modifier: Modifier = Modifier) {
    Row(
        modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        LocationView()
        NotificationIcon()
    }
}

@Composable
fun MainTitleCatalog(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(
            stringResource(R.string.tlt_find_your_new_part_one),
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                stringResource(R.string.tlt_find_your_new_part_two),
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Icon(
                footprint,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.size(30.dp)
            )
        }

    }
}


@Composable
fun NotificationIcon(modifier: Modifier = Modifier) {
    BadgedBox(
        badge = {
            Badge(
                containerColor = MaterialTheme.colorScheme.error,
                contentColor = MaterialTheme.colorScheme.onError
            ) { Text("1") }
        },
        modifier = modifier
    ) {
        Icon(
            Icons.Filled.Notifications,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.tertiary
        )
    }
}

@Composable
fun LocationView(modifier: Modifier = Modifier) {
    Column(modifier, verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(
            stringResource(R.string.lbl_location),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.secondary
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                Icons.Default.LocationOn,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
            Text(
                "New York, USA",
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.Bold
            )
            Icon(
                Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.secondary
            )
        }
    }
}

/**
 * Modifier extensions
 */

fun Modifier.shadowEdgePadding() = then(Modifier.padding(horizontal = 4.dp))

fun Modifier.sectionVerticalPadding() = then(Modifier.padding(top = 12.dp))

fun Modifier.gradientImage() = this.background(
    Brush.verticalGradient(
        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.7f)),
        startY = 300f
    )
)

@Preview(showBackground = true, heightDp = 12000)
@Composable
fun GreetingPreview() {
    PawfectMatchTheme {
        PawfectMatchApp()
    }
}
