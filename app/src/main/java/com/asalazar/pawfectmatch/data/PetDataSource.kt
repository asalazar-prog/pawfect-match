package com.asalazar.pawfectmatch.data

import com.asalazar.pawfectmatch.model.AnimalNature
import com.asalazar.pawfectmatch.model.Gender
import com.asalazar.pawfectmatch.model.Pet
import com.asalazar.pawfectmatch.model.Species

class PetDataSource {

    fun getPets(): List<Pet> {
        return listOf(
            Pet(
                id = 1U,
                name = "Max",
                species = Species.DOG,
                breed = "Golden Retriever",
                gender = Gender.MALE,
                ageInMonths = 36U,
                nature = listOf(AnimalNature.LOYAL, AnimalNature.ACTIVE),
                photo = 0 // TODO: Descargar las imagenes y vincularlos con el R.drawable real
            ),
            Pet(
                id = 2U,
                name = "Bella",
                species = Species.CAT,
                breed = "Persian Cat",
                gender = Gender.FEMALE,
                ageInMonths = 2U,
                nature = listOf(AnimalNature.PLAYFUL, AnimalNature.SOCIAL),
                photo = 0
            ),
            Pet(
                id = 3U,
                name = "Rocky",
                species = Species.DOG,
                breed = "Bulldog",
                gender = Gender.MALE,
                ageInMonths = 60U,
                nature = listOf(AnimalNature.GUARD, AnimalNature.LOYAL),
                photo = 0
            ),
            Pet(
                id = 4U,
                name = "Luna",
                species = Species.BUNNY,
                breed = "Holland Lop",
                gender = Gender.FEMALE,
                ageInMonths = 12U,
                nature = listOf(AnimalNature.QUIET, AnimalNature.SHY),
                photo = 0
            ),
            Pet(
                id = 5U,
                name = "Cooper",
                species = Species.DOG,
                breed = "Beagle",
                gender = Gender.MALE,
                ageInMonths = 24U,
                nature = listOf(AnimalNature.SMART, AnimalNature.ADVENTUROUS),
                photo = 0
            ),
            Pet(
                id = 6U,
                name = "Misty",
                species = Species.CAT,
                breed = "Siamese",
                gender = Gender.FEMALE,
                ageInMonths = 8U,
                nature = listOf(AnimalNature.PLAYFUL, AnimalNature.QUIET),
                photo = 0
            ),
            Pet(
                id = 7U,
                name = "Charlie",
                species = Species.BIRD,
                breed = "Cockatiel",
                gender = Gender.MALE,
                ageInMonths = 18U,
                nature = listOf(AnimalNature.SOCIAL, AnimalNature.ADVENTUROUS),
                photo = 0
            ),
            Pet(
                id = 8U,
                name = "Daisy",
                species = Species.DOG,
                breed = "Poodle",
                gender = Gender.FEMALE,
                ageInMonths = 48U,
                nature = listOf(AnimalNature.SMART, AnimalNature.FRIENDLY),
                photo = 0
            ),
            Pet(
                id = 9U,
                name = "Oliver",
                species = Species.CAT,
                breed = "Maine Coon",
                gender = Gender.MALE,
                ageInMonths = 14U,
                nature = listOf(AnimalNature.INDEPENDENT, AnimalNature.CALM),
                photo = 0
            ),
            Pet(
                id = 10U,
                name = "Toby",
                species = Species.DOG,
                breed = "Jack Russell",
                gender = Gender.MALE,
                ageInMonths = 10U,
                nature = listOf(AnimalNature.ACTIVE, AnimalNature.PLAYFUL),
                photo = 0
            )
        )
    }

    /**
     * TODO
     * Esta función actualmente devuelve un valor estático.
     * En una implementación real, esto debería calcularse dinámicamente en la capa de
     * Repositorio comparando las coordenadas GPS del usuario con las coordenadas del
     * albergue obtenidas mediante un endpoint.
     */
    fun getDistanceFromUser(petId: UInt): String {
        return "2.5 km away"
    }
}
