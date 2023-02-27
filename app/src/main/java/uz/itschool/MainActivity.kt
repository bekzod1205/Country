package uz.itschool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import uz.itschool.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var list = mutableListOf<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        createUser()

        var p = intent.getStringExtra("population")
        var a = intent.getStringExtra("area")
        var i = intent.getIntExtra("index",-1)
        if (i!=-1){
            list.get(i).population=p.toString()
            list.get(i).area=a.toString()
        }
        var adapter = Adapter(this, list)
        binding.main.adapter = adapter

        binding.main.setOnItemClickListener { _, _, i, _ ->
            var user = list.get(i)
            var intent = Intent(this, MoreInfoActivity::class.java)
            intent.putExtra("user", user)
            startActivity(intent)
        }
        binding.search.addTextChangedListener {
            var filter = mutableListOf<User>()
            if (it != null) {
                for (c in list) {
                    if (c.name.contains(it.toString())) {
                        filter.add(c)
                    }
                }
                adapter = Adapter(this, filter)
                binding.main.adapter = adapter
            }
        }

    }

    private fun createUser() {
        list.add(
            User(
                "Afghanistan",
                "38,93 mln",
                "652,860 km²",
                "https://cdn.britannica.com/40/5340-050-AA46700D/Flag-Afghanistan.jpg",
                "https://udayton.edu/magazine/2021/08/images/2108_afganistan_island.jpg",
                "http://sunnionline.us/english/wp-content/uploads/2021/10/DSC_6696-1024x684-1.jpg",
                "https://cdn.thecrazytourist.com/wp-content/uploads/2017/02/Panjshir-Valley.jpg"
            )
        )
        list.add(
            User(
                "Albania",
                "2,87 mln",
                "27,400 km²",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/Flag_of_Albania.svg/1200px-Flag_of_Albania.svg.png",
                "https://sofiaadventures.com/wp-content/uploads/2019/11/shutterstock_1456710995.jpg",
                "https://ychef.files.bbci.co.uk/976x549/p093hz3v.jpg",
                "https://www.nelt.com/wp-content/uploads/2019/08/albanija-bg.jpg"
            )
        )

        list.add(
            User(
                "Algeria",
                "43,85 mln",
                "2,38 mln km²",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Flag_of_Algeria.svg/1200px-Flag_of_Algeria.svg.png",
                "https://www.globalcsr.org/uploads/posts/2022-04-23/azrak_2vyBMxAX.jpeg",
                "https://lp-cms-production.imgix.net/image_browser/Constatine%20Gorge%2C%20Algeria%20-%20Getty%20RF.jpg",
                "https://www.state.gov/wp-content/uploads/2022/02/Algeria-2289x1406.png"
            )
        )
        list.add(
            User(
                "Andorra",
                "77 265",
                "470 km²",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/Flag_of_Andorra.svg/2560px-Flag_of_Andorra.svg.png",
                "https://planetofhotels.com/guide/sites/default/files/styles/paragraph__live_banner__lb_image__1880bp/public/live_banner/%20Andorra.jpg",
                "https://www.state.gov/wp-content/uploads/2018/11/Andorra-2109x1406.jpg",
                "https://www.dedalus.com/ne/wp-content/uploads/sites/15/2021/03/shutterstock_1853363233-scaled.jpg"
            )
        )
        list.add(
            User(
                "Angola",
                "32,86 mln",
                "1,24 mln km²",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9d/Flag_of_Angola.svg/1200px-Flag_of_Angola.svg.png",
                "https://media.istockphoto.com/id/486541172/photo/luanda-bay-area-daylight-le.jpg?s=612x612&w=0&k=20&c=OFIzGD2VtycwMwf6-NyxWDfMehkBGUvArcLRaMY41Gc=",
                "https://lp-cms-production.imgix.net/2019-06/83430407%20.jpg",
                "https://www.state.gov/wp-content/uploads/2018/11/Angola-e1555944773476-2500x1406.jpg"
            )
        )
        list.add(
            User(
                "Argentina",
                "45,19 mln",
                "2,73 mln km²",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Flag_of_Argentina.svg/1200px-Flag_of_Argentina.svg.png",
                "https://cdn.britannica.com/40/195440-050-B3859318/Congressional-Plaza-building-National-Congress-Buenos-Aires.jpg",
                "https://travellersworldwide.com/wp-content/uploads/2022/07/Shutterstock_1371228326.jpg.webp",
                "https://i.natgeofe.com/k/58cfabae-99a5-4df0-992c-b550dd05c57c/argentina-city-night.jpg?w=636&h=358"
            )
        )
        list.add(
            User(
                "Armenia",
                "2,96 mln",
                "28,470 km²",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2f/Flag_of_Armenia.svg/640px-Flag_of_Armenia.svg.png",
                "https://i.natgeofe.com/n/852429ea-cd87-4ec6-a81d-4a2e8a38e6e5/armenia_h_00000220066588_16x9.jpg?w=1200",
                "https://static.toiimg.com/photo/msid-64596276,width-96,height-65.cms",
                "https://lp-cms-production.imgix.net/features/2017/10/view-from-cascade-yerevan-armenia-cs-3000-af233802a806.jpg"
            )
        )
        list.add(
            User(
                "Australia",
                "25,49 mln",
                "7,68 mln km²",
                "https://cdn.britannica.com/78/6078-004-77AF7322/Flag-Australia.jpg",
                "https://a.cdn-hotels.com/gdcs/production5/d1996/54fdb73f-eee5-4612-a3e7-6fc7ed2f7bee.jpg?impolicy=fcrop&w=800&h=533&q=medium",
                "https://www.nationsonline.org/gallery/Australia/Uluru-from-above-MS.jpg",
                "https://i.insider.com/5f3424f2988ee31668198a09?width=700"
            )
        )
        list.add(
            User(
                "Azerbaijan",
                "10,13 mln",
                "82,658 km²",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/Flag_of_Azerbaijan.svg/1200px-Flag_of_Azerbaijan.svg.png",
                "https://bakutravelpackages.com/wp-content/uploads/2021/02/Azerbaijan-Tourism-min-1024x540.jpg",
                "https://www.telegraph.co.uk/content/dam/Travel/2016/August/baku-azerbaijan-travel-ap.jpg",
                "https://www.travelanddestinations.com/wp-content/uploads/2020/08/Azerbaijan-Highlights-Baku-Skyline.jpg"
            )
        )
        list.add(
            User(
                "Brazil",
                "212,55 mln",
                "8,35 mln km²",
                "https://upload.wikimedia.org/wikipedia/en/thumb/0/05/Flag_of_Brazil.svg/640px-Flag_of_Brazil.svg.png",
                "https://travellersworldwide.com/wp-content/uploads/2022/05/shutterstock_1369316819.jpg.webp",
                "https://www.celebritycruises.com/blog/content/uploads/2021/09/what-is-brazil-known-for-christ-the-redeemer-aerial-hero.jpg",
                "https://cdn.kimkim.com/files/a/content_articles/featured_photos/3158d8afedadf0a7bed038a518068f84f97459dd/big-2f1ff0c0898a4d5eb455c6e85ce30406.jpg"
            )
        )
        list.add(
            User(
                "China",
                "1,43 bln",
                "9,38 mln km²",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Flag_of_the_People%27s_Republic_of_China.svg/1200px-Flag_of_the_People%27s_Republic_of_China.svg.png",
                "https://cdn.britannica.com/89/179589-138-3EE27C94/Overview-Great-Wall-of-China.jpg?w=800&h=450&c=crop",
                "https://lp-cms-production.s3.amazonaws.com/public/2019-06/ae97554b8ec3c95dd1666153b671cc10-bell-tower-drum-tower.jpg?sharp=10&vib=20&w=1200",
                "https://static.euronews.com/articles/stories/07/18/79/18/1440x810_cmsv2_3d8f3684-a1b3-55a2-9b18-3f6148477fac-7187918.jpg"
            )
        )
        list.add(
            User(
                "Canada",
                "37,74 mln",
                "9,09 mln km²",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Canada_%28Pantone%29.svg/1200px-Flag_of_Canada_%28Pantone%29.svg.png",
                "https://a.cdn-hotels.com/gdcs/production159/d204/01ae3fa0-c55c-11e8-9739-0242ac110006.jpg",
                "https://cdn.britannica.com/93/94493-050-35524FED/Toronto.jpg",
                "https://a.travel-assets.com/findyours-php/viewfinder/images/res70/27000/27764-Moraine-Lake.jpg"
            )
        )
        list.add(
            User(
                "Costa Rica",
                "5,09 mln",
                "51,060 km²",
                "https://cdn.britannica.com/25/7225-004-65F33B16/Flag-Costa-Rica.jpg",
                "https://www.travelandleisure.com/thmb/alGRUejkJtx_5GWmV9aQ6w9h2Uw=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/costa-rica-arenal-volcano-COSTARICATG0621-171c9a2c18b448339d591ec2a4b41f6d.jpg",
                "https://www.travelandleisure.com/thmb/c7C73BF5wsFzdCnBX9Iz-jWoT2U=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/playa-hermosa-costa-rica_HERO_CRBEACH1122-2f3b789fad87446cb36cd642c062200c.jpg",
                "https://files.adventure-life.com/16/56/24/iStock-1136250609/1300x820.1674011278.webp"
            )
        )
        list.add(
            User(
                "Croatia",
                "4,10 mln",
                "55,960 km²",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Flag_of_Croatia.svg/800px-Flag_of_Croatia.svg.png",
                "https://travellersworldwide.com/wp-content/uploads/2022/12/Shutterstock_1935292256.jpg.webp",
                "https://media.cnn.com/api/v1/images/stellar/prod/220908114717-06-alternative-dalmatia-croatia-pula.jpg?c=original&q=w_1280,c_fill",
                "https://cdn.travelpulse.com/images/2aaaedf4-a957-df11-b491-006073e71405/2e2b6be6-9c85-4dc2-b245-8f5b13a64deb/630x355.jpg"
            )
        )


        list.add(
            User(
                "South Africa",
                "59.39 mln",
                "1.22 mln km²",
                "https://cdn.britannica.com/27/4227-050-00DBD10A/Flag-South-Africa.jpg",
                "https://www.nationsonline.org/gallery/South-Africa/Twelve-Apostles-Oudekraal.jpg",
                "https://cdn.kimkim.com/files/a/content_articles/featured_photos/5e127319f07b73e844245fc1e306775d2631d96e/big-34e9cae75b6de8ca7644837b839e89ba.jpg",
                "https://www.roadaffair.com/wp-content/uploads/2017/10/cape-town-south-africa-shutterstock_92510755.jpg"
            )
        )
    }
}