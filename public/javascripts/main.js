var twitterAnalysis = {
    cachDom: function() {
        this.$twitterPie = $("#twitterPie");
        this.$twitterChart2 = $("#twitterChart2");
        this.$twitterChart3 = $("#twitterChart3");
    },
    init: function() {
        this.cachDom();
        this.getFile();
    },
    getFile: function() {
        jQuery.get('sentiment.json', function(data, textStatus, xhr) {
            twitterAnalysis.drawCharts(data)
        });
        // jQuery.get('tweets.json', function(data, textStatus, xhr) {
        //     twitterAnalysis.postToSentiment(data)
        // });
    },
    postToSentiment(twietsJson) {
        var sentimentJson = [];
        twietsJson.tweets.forEach(function(element, index) {
            let twiet = {
                "text": element.text,
                "created": element.created,
                "retweetCount": element.retweetCount,
                "isRetweet": element.isRetweet,
                "retweeted": element.retweeted
            }
            var key = element.number;
            $.ajax({
                    url: 'http://sentiment.vivekn.com/api/batch/',
                    type: 'POST',
                    dataType: 'JSON',
                    async: false,
                    data: JSON.stringify({
                        [key]: element.text
                    }),
                })
                .done(function(response) {
                    twiet.confidence = response[0].confidence;
                    twiet.sentiment = response[0].result;
                    sentimentJson.push(twiet);
                })
                .fail(function() {
                    console.log("error");
                })
                .always(function() {
                    console.log("complete");
                });
        });
    },
    drawCharts: function(sentimentJson) {
        let positive = 0;
        let negative = 0;
        let neutral = 0;
        let isRetweet = 0;
        let isNotRetweet = 0;
        let retweeted = 0;
        let notRetweeted = 0;
        sentimentJson.forEach(function(element, index) {
            if (element.sentiment == "Positive") { positive++; }
            if (element.sentiment == "Negative") { negative++; }
            if (element.sentiment == "Neutral") { neutral++; }
            if (element.isRetweet == "TRUE") { isRetweet++; }
            if (element.isRetweet == "FALSE") { isNotRetweet++; }
            if (element.retweeted == "TRUE") { retweeted++; }
            if (element.retweeted == "FALSE") { notRetweeted++; }
        });
        var dataTwitterPie = {
            labels: [
                "Negative",
                "Positive",
                "Neutral"
            ],
            datasets: [{
                data: [positive, negative, neutral],
                backgroundColor: [
                    "#FF6384",
                    "#36A2EB",
                    "#FFCE56"
                ],
                hoverBackgroundColor: [
                    "#FF6384",
                    "#36A2EB",
                    "#FFCE56"
                ]
            }]
        };
        var myDoughnutChart = new Chart(this.$twitterPie, {
            type: 'pie',
            data: dataTwitterPie,
        });
        var dataTwitterChart2 = {
            labels: [
                "isRetweet",
                "isNotRetweet",
                "retweeted",
                "notRetweeted"
            ],
            datasets: [{
                label: "Tweeted",
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)',
                    'rgba(255, 159, 64, 0.2)'
                ],
                borderColor: [
                    'rgba(255,99,132,1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)',
                    'rgba(255, 159, 64, 1)'
                ],
                borderWidth: 1,
                data: [isRetweet, isNotRetweet, retweeted, notRetweeted]
            }]
        };
        var myDoughnutChart = new Chart(this.$twitterChart2, {
            type: 'bar',
            data: dataTwitterChart2,
        });
    },
    downloadFile: function(text, filename) {
            var a = document.createElement('a');
            a.setAttribute('href', 'data:text/plain;charset=utf-u,' + encodeURIComponent(text));
            a.setAttribute('download', filename);
            a.click()
        }
        // downloadFile(JSON.stringify(ctxData), "filename.json");
}
twitterAnalysis.init();
