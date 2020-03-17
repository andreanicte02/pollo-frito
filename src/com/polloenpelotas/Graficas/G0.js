var trace1 = { 
x: [1], 
y: [5], 
mode: 'markers'
}; 
var data = [trace1]; 
var layout = { 
title: "titulo",
xaxis:  {title: "etiquetax"},
yaxis:  {title: "etiquetay"},
}; 
Plotly.newPlot('G0', data, layout);
