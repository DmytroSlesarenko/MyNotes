const closeInput = document.getElementsByClassName("close");
const uncheckItem = document.querySelectorAll(".uncheck");
const checkItem = document.querySelectorAll(".check");
const listBox = document.querySelector(".list__content");

for (let i = 0; i < closeInput.length; i++) {
    closeInput[i].onclick = function () {
        const div = this.parentElement;
        div.remove();
    }
}

uncheckItem.forEach(function (item) {

    item.className = "uncheck";
    item.src = "/theme/img/uncheck.png";

    item.addEventListener("mouseover",function () {
        this.src = "/theme/img/uncheck-click.png"
    })
    item.addEventListener("mouseout",function () {
        this.src = "/theme/img/uncheck.png"
    })
    item.addEventListener("click", function () {
        if (item.className === "uncheck") {
            item.className = "check";
            item.src = "/theme/img/check.png";

            item.addEventListener("mouseover",function () {
                this.src = "/theme/img/check-click.png"
            })
            item.addEventListener("mouseout",function () {
                this.src = "/theme/img/check.png"
            })
        } else {
            item.className = "uncheck";
            item.src = "/theme/img/uncheck.png";

            item.addEventListener("mouseover",function () {
                this.src = "/theme/img/uncheck-click.png"
            })
            item.addEventListener("mouseout",function () {
                this.src = "/theme/img/uncheck.png"
            })
        }
    })
})

checkItem.forEach(function (item) {
    const hiddenInput = document.createElement("INPUT");
    hiddenInput.name = "box";
    hiddenInput.className = "checkValue";
    hiddenInput.style.display = "none";
    hiddenInput.value = "check";

    item.className = "check";
    item.src = "/theme/img/check.png";

    item.addEventListener("mouseover",function () {
        this.src = "/theme/img/check-click.png"
    })
    item.addEventListener("mouseout",function () {
        this.src = "/theme/img/check.png"
    })
    item.addEventListener("click", function () {
        if (item.className === "check") {
            item.className = "uncheck";
            hiddenInput.value = "uncheck";
            item.src = "/theme/img/uncheck.png";

            item.addEventListener("mouseover",function () {
                this.src = "/theme/img/uncheck-click.png"
            })
            item.addEventListener("mouseout",function () {
                this.src = "/theme/img/uncheck.png"
            })
        } else {
            item.className = "check";
            hiddenInput.value = "check";
            item.src = "/theme/img/check.png";

            item.addEventListener("mouseover",function () {
                this.src = "/theme/img/check-click.png"
            })
            item.addEventListener("mouseout",function () {
                this.src = "/theme/img/check.png"
            })
        }
    })
})

function newElement() {
    const box = document.createElement("DIV");
    const input = document.createElement("INPUT");
    const inputValue = document.getElementById("myInputs").value;
    const text = document.createTextNode(inputValue);
    box.className = "point";
    input.name = "lista";
    input.value = text.data;

    const checkBox = document.createElement("IMG");
    const hiddenInput = document.createElement("INPUT");
    hiddenInput.name = "box";
    hiddenInput.className = "checkValue";
    hiddenInput.style.display = "none";
    hiddenInput.value = "uncheck";
    checkBox.className = "uncheck";
    checkBox.src = "/theme/img/uncheck.png";


    checkBox.addEventListener("mouseover",function () {
        this.src = "/theme/img/uncheck-click.png"
    })
    checkBox.addEventListener("mouseout",function () {
        this.src = "/theme/img/uncheck.png"
    })

    checkBox.addEventListener("click", function () {
        if (checkBox.className === "uncheck") {
            checkBox.className = "check";
            hiddenInput.value = "check";
            checkBox.src = "/theme/img/check.png";

            checkBox.addEventListener("mouseover",function () {
                this.src = "/theme/img/check-click.png"
            })
            checkBox.addEventListener("mouseout",function () {
                this.src = "/theme/img/check.png"
            })
        } else {
            checkBox.className = "uncheck";
            hiddenInput.value = "uncheck";
            checkBox.src = "/theme/img/uncheck.png";

            checkBox.addEventListener("mouseover",function () {
                this.src = "/theme/img/uncheck-click.png"
            })
            checkBox.addEventListener("mouseout",function () {
                this.src = "/theme/img/uncheck.png"
            })
        }
    })

    box.appendChild(checkBox);
    box.appendChild(hiddenInput);

    if (inputValue === '') {
        alert("Complete point!")
    } else {
        const addInput = document.getElementById("myInputs");
        addInput.value = "";
        box.appendChild(input);
        document.getElementById("checklist").appendChild(box);
    }
    document.getElementById("checklist").value = "";

    const closeButton = document.createElement("IMG");
    closeButton.src = "/theme/img/cancel.png";
    closeButton.addEventListener("mouseover",function () {
        this.src = "/theme/img/cancel-click.png"
    })
    closeButton.addEventListener("mouseout",function () {
        this.src = "/theme/img/cancel.png"
    })
    closeButton.className = "close";
    box.appendChild(closeButton);

    for (let i = 0; i < closeInput.length; i++) {
        closeInput[i].onclick = function () {
            const div = this.parentElement;
            div.remove();
        }
    }
}

