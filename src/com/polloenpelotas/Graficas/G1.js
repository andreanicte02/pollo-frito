var data = [{
x: ["gato", "baca", "idiota"],
y: [20, 14, 23],
type: 'bar' 
}];  
 
var layout = { 
title: "titulo",
xaxis:  {title: "etiquetax"},
yaxis:  {title: "etiquetay"},
}; 
 
Plotly.newPlot('G1', data, layout);
