package com.example.tp1_duciel_romain.repository

import com.example.tp1_duciel_romain.view.model.MyObjectForRecyclerView
import com.example.tp1_duciel_romain.view.model.ObjectDataFooterSample
import com.example.tp1_duciel_romain.view.model.ObjectDataHeaderSample
import com.example.tp1_duciel_romain.view.model.RecyclerViewData

class NBATeamRepository {

    fun generateFakeData(): MutableList<MyObjectForRecyclerView> {
        val result = mutableListOf<MyObjectForRecyclerView>()

        mutableListOf(
            RecyclerViewData("Boston Celtics", "Est","1", "https://upload.wikimedia.org/wikipedia/fr/thumb/6/65/Celtics_de_Boston_logo.svg/1200px-Celtics_de_Boston_logo.svg.png"),
            RecyclerViewData("Milwaukee Bucks", "Est","2","https://upload.wikimedia.org/wikipedia/fr/3/34/Bucks2015.png"),
            RecyclerViewData("Cleveland Cavalier", "Est","3","https://upload.wikimedia.org/wikipedia/fr/0/06/Cavs_de_Cleveland_logo_2017.png"),
            RecyclerViewData("Brooklyn Nets", "Est","4","https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/Brooklyn_Nets_newlogo.svg/1200px-Brooklyn_Nets_newlogo.svg.png"),
            RecyclerViewData("Philadelphia 76ers", "Est","5","https://upload.wikimedia.org/wikipedia/en/thumb/0/0e/Philadelphia_76ers_logo.svg/1200px-Philadelphia_76ers_logo.svg.png"),
            RecyclerViewData("Atlanta Hawks", "Est","6","https://upload.wikimedia.org/wikipedia/en/thumb/2/24/Atlanta_Hawks_logo.svg/1200px-Atlanta_Hawks_logo.svg.png"),
            RecyclerViewData("Indiana Pacers", "Est","7","https://upload.wikimedia.org/wikipedia/fr/4/48/Pacers_de_l%27Indiana_2017.png"),
            RecyclerViewData("New York Knicks", "Est","8","https://upload.wikimedia.org/wikipedia/en/thumb/2/25/New_York_Knicks_logo.svg/1200px-New_York_Knicks_logo.svg.png"),
            RecyclerViewData("Toronto Raptors", "Est","9","https://upload.wikimedia.org/wikipedia/en/thumb/3/36/Toronto_Raptors_logo.svg/1200px-Toronto_Raptors_logo.svg.png"),
            RecyclerViewData("Miami Heat", "Est","10","https://upload.wikimedia.org/wikipedia/en/thumb/f/fb/Miami_Heat_logo.svg/800px-Miami_Heat_logo.svg.png"),
            RecyclerViewData("Chicago Bulls", "Est","11","https://upload.wikimedia.org/wikipedia/fr/thumb/d/d1/Bulls_de_Chicago_logo.svg/1200px-Bulls_de_Chicago_logo.svg.png"),
            RecyclerViewData("Washington Wizards", "Est","12","https://upload.wikimedia.org/wikipedia/en/thumb/0/02/Washington_Wizards_logo.svg/1200px-Washington_Wizards_logo.svg.png"),
            RecyclerViewData("Orlando Magic", "Est","13","https://upload.wikimedia.org/wikipedia/fr/b/bd/Orlando_Magic_logo_2010.png"),
            RecyclerViewData("Charlotte Hornets", "Est","14","https://upload.wikimedia.org/wikipedia/fr/thumb/f/f3/Hornets_de_Charlotte_logo.svg/1200px-Hornets_de_Charlotte_logo.svg.png"),
            RecyclerViewData("Detroit Pistons", "Est","15","https://upload.wikimedia.org/wikipedia/commons/6/6a/Detroit_Pistons_primary_logo_2017.png"),
            RecyclerViewData("New Orleans Pelicans", "Ouest","1","https://upload.wikimedia.org/wikipedia/fr/2/21/New_Orleans_Pelicans.png"),
            RecyclerViewData("Memphis Grizzlies", "Ouest","2","https://upload.wikimedia.org/wikipedia/en/thumb/f/f1/Memphis_Grizzlies.svg/1200px-Memphis_Grizzlies.svg.png"),
            RecyclerViewData("Denver Nuggets", "Ouest","3","https://upload.wikimedia.org/wikipedia/fr/3/35/Nuggets_de_Denver_2018.png"),
            RecyclerViewData("Phoenix Suns", "Ouest","4","https://upload.wikimedia.org/wikipedia/fr/5/56/Phoenix_Suns_2013.png"),
            RecyclerViewData("Sacramento Kings", "Ouest","5","https://upload.wikimedia.org/wikipedia/fr/thumb/9/95/Kings_de_Sacramento_logo.svg/1200px-Kings_de_Sacramento_logo.svg.png"),
            RecyclerViewData("Portland Trail Blazers", "Ouest","6","https://upload.wikimedia.org/wikipedia/en/thumb/2/21/Portland_Trail_Blazers_logo.svg/1200px-Portland_Trail_Blazers_logo.svg.png"),
            RecyclerViewData("Los Angeles Clippers", "Ouest","7","https://upload.wikimedia.org/wikipedia/fr/thumb/c/cb/Clippers_de_Los_Angeles_logo.svg/1200px-Clippers_de_Los_Angeles_logo.svg.png"),
            RecyclerViewData("Golden State Warriors", "Ouest","8","https://upload.wikimedia.org/wikipedia/en/thumb/0/01/Golden_State_Warriors_logo.svg/1200px-Golden_State_Warriors_logo.svg.png"),
            RecyclerViewData("Utah Jazz", "Ouest","9","https://upload.wikimedia.org/wikipedia/fr/3/3b/Jazz_de_l%27Utah_logo.png"),
            RecyclerViewData("Dallas Mavericks", "Ouest","10","https://upload.wikimedia.org/wikipedia/fr/thumb/b/b8/Mavericks_de_Dallas_logo.svg/1200px-Mavericks_de_Dallas_logo.svg.png"),
            RecyclerViewData("Minesota Timberwolves", "Ouest","11","https://upload.wikimedia.org/wikipedia/fr/d/d9/Timberwolves_du_Minnesota_logo_2017.png"),
            RecyclerViewData("Los Angeles Lakers", "Ouest","12","https://upload.wikimedia.org/wikipedia/commons/thumb/3/3c/Los_Angeles_Lakers_logo.svg/1200px-Los_Angeles_Lakers_logo.svg.png"),
            RecyclerViewData("Oklahoma City Thunder", "Ouest","13","https://upload.wikimedia.org/wikipedia/fr/thumb/4/4f/Thunder_d%27Oklahoma_City_logo.svg/1200px-Thunder_d%27Oklahoma_City_logo.svg.png"),
            RecyclerViewData("San Antonio Spurs", "Ouest","14","https://upload.wikimedia.org/wikipedia/fr/thumb/a/a2/San_Antonio_Spurs.svg/1200px-San_Antonio_Spurs.svg.png"),
            RecyclerViewData("Houston Rockets", "Ouest","15","https://upload.wikimedia.org/wikipedia/fr/e/e1/Houston_Rockets_logo_2019.png"),
        ).groupBy { it.conference }
            .forEach { (conferenceResult, items) ->
                result.add(ObjectDataHeaderSample("Conférence $conferenceResult"))
                result.addAll(items)
                result.add(ObjectDataFooterSample("Equipes: ${items.size}"))
            }
        return result
    }

}