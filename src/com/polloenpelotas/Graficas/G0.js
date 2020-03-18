var trace1 = { 
x: [1], 
y: [1], 
mode: 'lines+markers'
}; 
var data = [trace1]; 
var layout = { 
title: "titulo",
xaxis:  {title: "ejex"},
yaxis:  {title: "ejey"},
}; 
Plotly.newPlot('G0', data, layout);
