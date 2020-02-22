function onReceiveDataVote(data) {
    if (data !== null) {
        create_chart(data);
    } else {
        console.log("ERREUR");
    }
}

function create_chart(data) {
    var canvas = document.createElement('canvas');
    var names = data.names;
    var scores = data.scores;
    document.getElementById("resultView").appendChild(canvas);
    var myPieChart = new Chart(canvas, {
        type: "pie",
        data: {
            datasets: [{
                data: scores,
                backgroundColor: ["#123456", "#654321", "#321456", "#765423"]
            }],

            // These labels appear in the legend and in the tooltips when hovering different arcs
            labels: names
        },
        options: {}
    });
}