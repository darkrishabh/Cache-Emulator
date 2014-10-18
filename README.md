

Assignment - 

You are to write (in any language you like) a program that simulates a simple cache. The 
parameters associated with the memory system are as follows:
• Memory Block Size = Cache Line Size = 16
• Number of Blocks in Memory =16
• Number of Cache Lines = 8
• 2-way Set Associative Mapped Cache
• Write Through Cache Policy

Your memory has the following initial values:
 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25
20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35
30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45
40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55
50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65
60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75
70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85
80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95
90 91 92 93 94 95 96 97 98 99 100 101 102 103 104 105
100 101 102 103 104 105 106 107 108 109 110 111 112 113 114 115
110 111 112 113 114 115 116 117 118 119 120 121 122 123 124 125
120 121 122 123 124 125 126 127 128 129 130 131 132 133 134 135
130 131 132 133 134 135 136 137 138 139 140 141 142 143 144 145
140 141 142 143 144 145 146 147 148 149 150 151 152 153 154 155 
150 151 152 153 154 155 156 157 158 159 160 161 162 163 164 165

The Flow - 

init_cache
init mem
repeat for ever
{
Print the number of hits and misses
print_mem 
print_cache
Get from the keyboard the command from the CPU on the bus:
If the command is READ, get the block number, and offset. Then 
if ( is_cache_hit)
increment num_read_hits counter
else
increment num_read_misses counter
load_from_mem
print the value of the memory location requested
If the command is WRITE, get the block number, offset, and value. Then 
if ( is_cache_hit)
increment num_write_hits counter 
write_to_cache
write_thru_to_mem
else
increment num_write_misses counter
load_from_mem
print the value of the memory location written
if the command is QUIT, exit the loop
}