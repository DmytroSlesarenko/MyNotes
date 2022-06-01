<script>
    function showText() {
        document.getElementById("main").style.marginLeft = "250px";
        const hr = document.querySelectorAll("hr");
        hr.forEach( function (item) {
            item.style.width = "220px";
        })
    }

    function hideText() {
        document.getElementById("main").style.marginLeft = "54px";
        const hr = document.querySelectorAll("hr");
        hr.forEach( function (item) {
            item.style.width = "45px";
        })
    }
</script>
</body>
</html>