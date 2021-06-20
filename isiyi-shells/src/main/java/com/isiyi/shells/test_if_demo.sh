#!/usr/bin/env bash
if [ "$1" == "tree" ]; then
    insert_type="INSERT"
else
    insert_type="UPSERT"
fi

echo "${insert_type}"
