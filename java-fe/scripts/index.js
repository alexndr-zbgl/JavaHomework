let herosList = document.querySelector("#heros");
let buttonsList = document.querySelector('#buttons');
const IMG_BASE_URL = 'https://starwars-visualguide.com/assets/img/characters/${id}.jpg'
let heros = []
const list_element = document.getElementById('list');
const pagination_element = document.getElementById('pagination');

let currentPage = 1;
let pages;
let items = 2;

const generateButtons = (index) => {
    return `
        <div id="list_element_${index}" class="list_element">
            <input type="text" id="input_${index}" />

            <button>
                Change name
            </button>
        </div>
    `
}

const generateHeroLayout = (heroData, index) => {
    const heroUrl = heroData.url
    const splitted = heroUrl.split('/');
    const heroId = splitted[splitted.length - 2];

    const heroImgUrl = IMG_BASE_URL.replace('${id}', heroId);

  return `<li class="hero-element">
    <div>
        <img src="${heroImgUrl}" alt=""/>
    </div>
    <div class="hero-details">
        <span>
        name: ${heroData.name}
        </span>
        <span>
            age: ${heroData.gender}
        </span>
        <span>
            age: ${heroData.birth_year}
        </span>

        ${generateButtons(index)}
    </div>
    </li>`;
};

const generateButtonLayout = (pageNum) => {
  if(currentPage == pageNum){
    return `<li class="button-element" id="button-element">
  <button class="buttonNum active-button">
      ${pageNum}
  </button>
  </li>`;
  }
  else{
    return `<li class="button-element" id="button-element">
  <button class="buttonNum">
      ${pageNum}
  </button>
  </li>`;

  }
  
};

const generateHeroList = (heros, currPage) => {

    herosList.innerHTML = '';
    
  
    let start = items * currPage;
    let end =  start + items;

    let paginatedItems = heros.slice(start, end)

    for(let i = 0; i < paginatedItems.length; i++){
      herosList.insertAdjacentHTML("beforeend", generateHeroLayout(paginatedItems[i], i));
    }
};

const generateButtonsList = (heros) => {

  buttonsList.innerHTML = '';

  pages = Math.ceil(heros.length/items);

  for(let i = 1; i < pages + 1; i++){
      buttonsList.insertAdjacentHTML("beforeend", generateButtonLayout(i));
  }

  let buttonsArray = document.getElementsByClassName("buttonNum");
  console.log('buttons');

  for(let i = 0; i < buttonsArray.length; i++){
    buttonsArray[i].addEventListener('click', () => handlePageChange(buttonsArray[i], heros, buttonsArray));
  }  
  
}

const handlePageChange = (button, heros, buttonsArray) => {
    currentPage = button.innerText - 1;
    generateHeroList(heros, currentPage);
    updateButtons(buttonsArray, currentPage);
}

const updateButtons = (buttonsArray, currentPage) => {
    for(i = 0; i < buttonsArray.length; i++){
      if(buttonsArray[i].innerText - 1 == currentPage){
        buttonsArray[i].classList.add('active-button');
      }
      else{
        buttonsArray[i].classList.remove('active-button');
      }
    }
}

const handleInputChange = (event) => {
    console.log(event.target.value)
}

const handleBtnClick = (heroName, index) => {
    const hero = heros[index]
    hero.name = heroName;
    generateHeroList(heros)
    const lis = document.querySelectorAll('li')
    const toChangeLi = lis[index]

    toChangeLi.classList.add('red');
}


fetch("https://swapi.dev/api/people")
  .then((response) => {
    return response.json();
  })
  .then((data) => {
    console.log(data);
    heros = data.results
    generateHeroList(heros, currentPage-1);
    generateButtonsList(heros);

    const listElements = document.querySelectorAll('.list_element') 
    
    for(let i = 0; i < listElements.length; i++) {
        const el = listElements[i];
        const [input, button] = el.children

        button.addEventListener('click', () => handleBtnClick(input.value, i))

    }
  });

  