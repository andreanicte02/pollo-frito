var trace1 = { 
x: [1,2,3,4], 
y: [1.0, 2.0, 1.0, 4.0], 
mode: 'markers'
}; 
var data = [trace1]; 
var layout = { 
title: "titulo",
xaxis:  {title: "etiquetax"},
yaxis:  {title: "etiquetay"},
}; 
Plotly.newPlot('G2', data, layout);
