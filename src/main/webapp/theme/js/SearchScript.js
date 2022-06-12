
function myFunction() {
    // Declare variables
    const input = document.getElementById("mySearch");
    const filter = input.value.toUpperCase();
    const box = document.querySelector(".content__box");
    const note = box.getElementsByClassName("notes__element");

    // Loop through all list items, and hide those who don't match the search query
    for (let i = 0; i < note.length; i++) {
        const description = note[i].getElementsByClassName("inside")[0];
        if (description.innerHTML.toUpperCase().indexOf(filter) > -1) {
            note[i].style.display = "";
        } else {
            note[i].style.display = "none";
        }
    }
}

function myFunctionFolder() {
    // Declare variables
    const input = document.getElementById("mySearch");
    const filter = input.value.toUpperCase();
    const box = document.querySelector(".content__box");
    const note = box.getElementsByClassName("folders__element");

    // Loop through all list items, and hide those who don't match the search query
    for (let i = 0; i < note.length; i++) {
        const description = note[i].getElementsByClassName("inside")[0];
        if (description.innerHTML.toUpperCase().indexOf(filter) > -1) {
            note[i].style.display = "";
        } else {
            note[i].style.display = "none";
        }
    }
}
