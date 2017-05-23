var twitterAnalysis = {
    cachDom: function() {
        this.$nastyTweets = $("#nastyTweets");
        this.$clearTweets = $("#clearTweets");
        this.$twitterChart3 = $("#twitterChart3");
        this.$twitterChart4 = $("#twitterChart4");
        this.$twitterChart5 = $("#twitterChart5");
    },
    init: function() {
        this.cachDom();
        this.getFile();
    },
    getFile: function() {
        jQuery.get('nastyTweetsSentiment.json', function(data, textStatus, xhr) {
            twitterAnalysis.drawNastyCharts(data)
        });
        jQuery.get('clearTweetsSentiment.json', function(data, textStatus, xhr) {
            twitterAnalysis.drawClearCharts(data)
        });
        jQuery.get('nastyTweetsSentiment.json', function(data, textStatus, xhr) {
            twitterAnalysis.drawCommon(data)
        });
        // jQuery.get('clearTweets.json', function(data, textStatus, xhr) {
        //     twitterAnalysis.postToSentiment(data)
        // });
    },
    drawCommon: function(sentimentJson) {
        let isRetweet = 0;
        let isNotRetweet = 0;
        let retweeted = 0;
        let notRetweeted = 0;
        let confidence51 = 0;
        let confidence50 = 0;
        let confidenceArray = [];
        sentimentJson.forEach(function(element, index) {
            if (element.isRetweet == "TRUE") { isRetweet++; }
            if (element.isRetweet == "FALSE") { isNotRetweet++; }
            if (element.retweeted == "TRUE") { retweeted++; }
            if (element.retweeted == "FALSE") { notRetweeted++; }
            if (element.confidence > 50) { confidence51++; } else if (element.confidence == 50) {
                confidence50++;
            }
            confidenceArray.push(element.confidence);
        });
        let dataTwitterChart2 = {
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
        let dataTwitterPie = {
            labels: [
                "confidence level equal 50",
                "confidence level over 50"
            ],
            datasets: [{
                data: [confidence50, confidence51],
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
        let myDoughnutChart = new Chart(this.$twitterChart3, {
            type: 'bar',
            data: dataTwitterChart2,
        });
        let myChart = new Chart(this.$twitterChart4, {
            type: 'pie',
            data: dataTwitterPie,
        });
        let myLineChart = new Chart(this.$twitterChart5, {
            type: 'line',
            data: {
                datasets: [{
                    label: 'Confidence level',
                    data: confidenceArray,
                }]
            },
        });
    },
    drawClearCharts: function(sentimentJson) {
        let positive = 0;
        let negative = 0;
        let neutral = 0;
        sentimentJson.forEach(function(element, index) {
            if (element.sentiment == "Positive") { positive++; }
            if (element.sentiment == "Negative") { negative++; }
            if (element.sentiment == "Neutral") { neutral++; }
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
        let myChart = new Chart(this.$clearTweets, {
            type: 'pie',
            data: dataTwitterPie,
        });
    },
    drawNastyCharts: function(sentimentJson) {
        let positive = 0;
        let negative = 0;
        let neutral = 0;
        sentimentJson.forEach(function(element, index) {
            if (element.sentiment == "Positive") { positive++; }
            if (element.sentiment == "Negative") { negative++; }
            if (element.sentiment == "Neutral") { neutral++; }
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
        let myChart = new Chart(this.$nastyTweets, {
            type: 'pie',
            data: dataTwitterPie,
             options: {
                "cutoutPercentage":0
             }
        });
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
            var form = new FormData();
            form.append("txt", element.text);
            var settings = {
                "async": false,
                "crossDomain": true,
                "url": "http://sentiment.vivekn.com/api/text/",
                "method": "POST",
                "processData": false,
                "contentType": false,
                "mimeType": "multipart/form-data",
                "data": form
            }

            $.ajax(settings).done(function(response) {
                twiet.confidence = JSON.parse(response).result.confidence
                twiet.sentiment = JSON.parse(response).result.sentiment
                sentimentJson.push(twiet);
                console.log("done");
            });
        });
        this.downloadFile(JSON.stringify(sentimentJson), "sentiment.json");
    },
    downloadFile: function(text, filename) {
        var a = document.createElement('a');
        a.setAttribute('href', 'data:text/plain;charset=utf-u,' + encodeURIComponent(text));
        a.setAttribute('download', filename);
        a.click()
    }
}
twitterAnalysis.init();
