package com.asalazar.pawfectmatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asalazar.pawfectmatch.model.Species
import com.asalazar.pawfectmatch.ui.icon.footprint
import com.asalazar.pawfectmatch.ui.theme.PawfectMatchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { PawfectMatchTheme { PawfectMatchApp() } }
    }
}

@Composable
fun PawfectMatchApp() {

    var searchInputValue by remember { mutableStateOf("") }
    var speciesSelected by remember { mutableStateOf<Species?>(null) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(vertical = 8.dp)
            .background(color = MaterialTheme.colorScheme.surface),
        topBar = {
            PawfectMatchTopBar(
                Modifier
                    .screenHorizontalPadding()
                    .fillMaxWidth()
            )
        }
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .padding(vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            MainTitleCatalog(modifier = Modifier.screenHorizontalPadding())
            SearchInput(
                value = searchInputValue,
                onValueChange = { searchInputValue = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .screenHorizontalPadding()
            )
            SpeciesFilterRow(speciesSelected) {
                speciesSelected = it
            }
        }
    }
}

@Composable
fun SpeciesFilterRow(
    selectedSpecies: Species?,
    onSpeciesSelected: (Species?) -> Unit
) {
    val speciesList = listOf(null) + Species.entries

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
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
            modifier = Modifier.size(80.dp)
        ) {
            Icon(
                species?.icon ?: footprint,
                contentDescription = null,
                modifier = Modifier.padding(20.dp)
            )
        }
        Text(species?.labelRes?.let { stringResource(it) } ?: "All",
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
fun SearchInput(
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
                text = "Search breed, age or name",
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
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                stringResource(R.string.tlt_find_your_new_part_two),
                style = MaterialTheme.typography.headlineMedium,
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
fun Modifier.screenHorizontalPadding() = then(Modifier.padding(horizontal = 16.dp))

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PawfectMatchTheme {
        PawfectMatchApp()
    }
}
