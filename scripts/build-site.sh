#!/usr/bin/env bash
# Assembles the GitHub Pages site: the page, the fat jar and the example programs
# (renamed as listed in web/ejemplos.json). Run after `mvn package`.
set -euo pipefail
cd "$(dirname "$0")/.."

out=${1:-site}
rm -rf "$out"
mkdir -p "$out/ejemplos"
cp web/index.html web/ejemplos.json "$out/"
cp target/pollo-frito.jar "$out/"

python3 - "$out" <<'PY'
import json, shutil, sys
out = sys.argv[1]
for ex in json.load(open("web/ejemplos.json")):
    shutil.copy(f"src/com/polloenpelotas/ArchivosPrueba/{ex['source']}", f"{out}/ejemplos/{ex['file']}")
    print(f"{ex['source']} -> ejemplos/{ex['file']}")
PY
