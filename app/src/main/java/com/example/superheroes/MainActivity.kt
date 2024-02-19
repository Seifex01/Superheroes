package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroRepository.heroes
import com.example.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperHeroApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroApp(modifier: Modifier = Modifier) {
    /*
    Column(modifier.fillMaxSize()) {

        HeroTopAppBar()
        HeroList(heroes = heroes)
    }
    */
    Scaffold(
        topBar = {
            HeroTopAppBar()
        }

    ) { it ->


                LazyColumn(contentPadding = it) {
                    items(heroes) {
                        HeroCard(hero = it)
                    }
                }

        }
    }


@Composable
fun HeroCard(
    hero: Hero,
    modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(all = 16.dp),
            verticalAlignment = Alignment.CenterVertically


        ){
            Column(
                modifier
                    .weight(1f),
                verticalArrangement = Arrangement.Center

            ) {
                Text(
                    text = LocalContext.current.getString(hero.nombre),
                    modifier = Modifier,
                    style = MaterialTheme.typography.displaySmall
                    )

                Text(
                    text = LocalContext.current.getString(hero.descripcion),
                    modifier = Modifier,
                    style = MaterialTheme.typography.bodyLarge
                    )
            }
            Spacer(
                modifier = Modifier
                    .width(16.dp)
            )
            Box(
                modifier = Modifier
                    .size(72.dp),
                    ){
                Image(
                    painter = painterResource(hero.imageResourceId),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(MaterialTheme.shapes.small)

                )
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroTopAppBar(modifier: Modifier = Modifier){
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun SuperHeroAppPreview() {
    Row {
        SuperheroesTheme(darkTheme = false) {
            SuperHeroApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SuperHeroAppDarkThemePreview() {
    SuperheroesTheme(darkTheme = true) {
        SuperHeroApp()
    }
}

