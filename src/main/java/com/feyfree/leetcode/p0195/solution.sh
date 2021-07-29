# solution 1
sed -n '10, 10p' file.txt

# solution 2
tail -n +10 file.txt | head -1

# solution 3
awk 'NR == 10' file.txt
