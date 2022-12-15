(() => {
    "use strict";
    function isWebp() {
        function testWebP(callback) {
            let webP = new Image;
            webP.onload = webP.onerror = function() {
                callback(2 == webP.height);
            };
            webP.src = "data:image/webp;base64,UklGRjoAAABXRUJQVlA4IC4AAACyAgCdASoCAAIALmk0mk0iIiIiIgBoSygABc6WWgAA/veff/0PP8bA//LwYAAA";
        }
        testWebP((function(support) {
            let className = true === support ? "webp" : "no-webp";
            document.documentElement.classList.add(className);
        }));
    }
    let addWindowScrollEvent = false;
    setTimeout((() => {
        if (addWindowScrollEvent) {
            let windowScroll = new Event("windowScroll");
            window.addEventListener("scroll", (function(e) {
                document.dispatchEvent(windowScroll);
            }));
        }
    }), 0);
    window["FLS"] = true;
    isWebp();
    // url.search // '?message=hello&who=world'
})();

const url = document.location.search;
// console.log(url);
//
// if(document.location.search = ""){
//
// }


// document.getElementById("#image").classList.add(".beagle");
switch (url) {
    case "?arg=Beagle":
        console.log("Beagle");
        // обращаемся к элементу с классом .rezult__img и добавляем ему класс .rezult__img--beagle
        var d = document.getElementById("image");
        d.className += " beagle";
        //Взять элемент с id="title" и добавить ему текст
        document.getElementById("title").innerHTML = "Бигль";
        document.getElementById("text").innerHTML = "Бигль (англ. beagle — гончая) — охотничья порода собак, выведенная в Великобритании. Среднего размера, внешне сходна с + фоксхаундом, но мельче, с более короткими ногами и болеедлинными и мягкими ушами (по стандарту породы уши должныдоходить до кончика носа). Рост — от 33 до 40 см в холке, вес— между 9 и 14 кг, суки мельче кобелей.";
        break;
    case "?arg=Corgi":
        console.log("corgi");
        // обращаемся к элементу с классом .rezult__img и добавляем ему класс .corgi
        var d = document.getElementById("image");
        d.className += " corgi";
        document.getElementById("title").innerHTML = "Корги";
        document.getElementById("text").innerHTML = "Зародилась порода в Уэльсе, где она стала одной из первых пастушьих собак. Вельш-корги получили распространение в XX веке. Основой для выведения породы, вероятно, послужили шведский вальхунд (вестготашпиц) или исландская собака.\n" +
            "По одной из легенд, объясняющих появление этих собак, щенков людям подарили феи, у которых порода использовалась в качестве ездовых. Этим сторонники версии объясняют отметину в виде седла на спине у вельш-корги пемброк.\n" +
            "Согласно другой валлийской легенде, двух щенков, сидящих на поваленном дереве в лесу, нашли крестьянские дети и принесли домой.";
        break;
    case "?arg=Blenheim_spaniel":
        console.log("Blenheim_spaniel");
        // обращаемся к элементу с классом .rezult__img и добавляем ему класс .rezult__img--Blenheim_spaniel
        var d = document.getElementById("image");
        d.className += " Blenheim_spaniel";
        document.getElementById("title").innerHTML = "Спаниэль";
        document.getElementById("text").innerHTML = "Cпаниель – приветливый умница с проникновенным взглядом и длинной атласной шерсткой, готовый «утопить» в море собственного обаяния любого, кто окажется в поле зрения. Из этих энергичных, общительных симпатяг получаются исключительные приятели. Поднять настроение, рассмешить, снять напряжение – все это собаки готовы проделывать для хозяина каждый день в обмен лишь на доброе слово и ласку. Недаром на родине породы, в Англии, за кавалер-кингами давно утвердилась репутация профессиональных утешителей.";
        break;
    case "?arg=Dalmatian":
        console.log("dalmatian");
        // обращаемся к элементу с классом .rezult__img и добавляем ему класс .rezult__img--dalmatian
        var d = document.getElementById("image");
        d.className += " dalmatian";
        document.getElementById("title").innerHTML = "Далматин";
        document.getElementById("text").innerHTML = "Далматин принадлежит к числу пород, которым «медийность» и сиюминутная популярность принесли больше вреда, чем пользы. Собаки с непростым характером и высокими потребностями к ежедневным упражнениям уживаются далеко не с каждым поклонником диснеевского мультфильма. Зато опытные и ответственные владельцы найдут в энергичном создании преданного друга и прекрасного компаньона.";
        break;
    case "?arg=German_shepherd":
        console.log("german_shepherd");
        // обращаемся к элементу с классом .rezult__img и добавляем ему класс .german_shepherd
        var d = document.getElementById("image");
        d.className += " german_shepherd";
        document.getElementById("title").innerHTML = "Овчарка";
        document.getElementById("text").innerHTML = "Овчарка – завсегдатай верхушек рейтингов самых умных, самых преданных, самых обучаемых питомцев. Благородные «лица» этих собак часто мелькают в сюжетах новостей, на полосах газет и даже в заглавных ролях различных телешоу. Но главным призванием немцев остается не актерская карьера, а охрана порядка. Они служат в полиции, пограничных и таможенных подразделениях, помогают в выполнении поисковых и спасательных операций. А дома представители этой породы оберегают покой и имущество хозяев, дарят своим владельцам массу положительных эмоций.";
        break;
    case "?arg=Huskies":
        console.log("huskies");
        // обращаемся к элементу с классом .rezult__img и добавляем ему класс .huskies
        var d = document.getElementById("image");
        d.className += " huskies";
        document.getElementById("title").innerHTML = "Хаски";
        document.getElementById("text").innerHTML = "Хаски — заводская специализированная порода собак, выведенная чукчами северо-восточной части Сибири и зарегистрированная американскими кинологами в 1930-х годах как ездовая собака, полученная от аборигенных собак Дальнего Востока России, в основном из Анадыря, Колымы, Камчатки у местных оседлых приморских племён — юкагиров, кереков, азиатских эскимосов и приморских чукчей — анкальын (приморские, поморы — от анкы (море)). Эта аборигенная ездовая собака Дальнего Востока является одной из древнейших пород собак. В настоящее время выведенная порода «сибирский хаски» используется не только как ездовая, но и как собака-компаньон и шоу-выставочная собака и собака поводырь.";
        break;
    case "?arg=Labrador":
        var d = document.getElementById("image");
        console.log("Labrador");
        d.className += " Labrador";
        // обращаемся к элементу с классом .rezult__img и добавляем ему класс .labrador
        document.getElementById("title").innerHTML = "Лабрадор";
        document.getElementById("text").innerHTML = "Лабрадор получил столь широкое распространение благодаря удивительно удачному сочетанию внешних данных и «рабочих» качеств, которые позволяют представителям породы быть не только компаньонами в повседневной жизни, но и нести службу на благо человека. Они регулярно попадают на верхние строчки рейтингов «самых преданных», «самых послушных», «самых трудолюбивых» собак по мнению профессиональных заводчиков и обычных владельцев.";
        break;
    case "?arg=Shar_pei":
        console.log("shar_pei");
        var d = document.getElementById("image");
        d.className += " shar_pei";
        document.getElementById("title").innerHTML = "Шарпей";
        document.getElementById("text").innerHTML = "Шарпей из тех пород, которые невозможно не заметить на любой выставке собак или просто площадке для выгула. Необычная форма головы и, конечно, фирменные складки выделяют их среди сородичей, а дополняет картину иссиня-черный язык – среди сотен современных пород таким могут похвастаться разве что чау-чау. Но не менее знаменит среди заводчиков и их независимый нрав.";
        break;
}