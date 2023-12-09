import {Graph} from "./Graph";
const RADIUS_INPUT_TAG_NAME: string = 'r_hinput';

(() => {
    const graphContainer = document.createElement('div');
    graphContainer.classList.add('graph-container');

    const canvas = document.createElement('canvas');
    canvas.id = 'graph';
    canvas.width = 300;
    canvas.height = 300;

    graphContainer.appendChild(canvas);
    const contentDiv = document.querySelector('.content');
    contentDiv.insertBefore(graphContainer, contentDiv.firstChild);
})();

const GRAPH: Graph = new Graph();

function findAndReturnSelectedRadius(): number {
    const selectedElement: HTMLInputElement = document.getElementById(RADIUS_INPUT_TAG_NAME) as HTMLInputElement;
    console.log('take value: ', selectedElement.value);
    return Number(selectedElement.value);
}

async function redrawGraphAndPoints() {
    const radius: number = findAndReturnSelectedRadius();

    console.log('current radius: ', radius);
    if (validateRadius(radius)) {
        console.log('try to draw graph');
        GRAPH.redrawAll(radius);
    } else {
        console.log("radius isn't valid: ", radius);
    }

    // TODO: drawAllPoints(graph);
}

function validateRadius(radius: number): boolean {
    return Number.isFinite(radius) && radius >= 1 && radius <= 3;
}

document.addEventListener("DOMContentLoaded", redrawGraphAndPoints);

document
    .getElementById("r")
    .addEventListener("change", redrawGraphAndPoints);