

class HashTable:
    def __init__(self):
        self.table = [None] * 10
    
    # put key := string, value := any
    def put(self, key, value):
        hash_index = self.hash_func(key) # hash a string
        if self.table[hash_index] is None:
            self.table[hash_index] = []
        self.table[hash_index].append(tuple([key, value])) # use chaining to handle collision
    
    # simple hash function
    # lazy approach :)
    def hash_func(self, key):
        return (len(key) + 3) % 10
    
    def get_value(self, key):
        hash_index = self.hash_func(key)
        for k, v in self.table[hash_index]:
            if key == k:
                return v
        
        return "No key in table"
    
    def update_value(self, key, new_value):
        hash_index = self.hash_func(key)
        for i in range(len(self.table[hash_index])):
            if self.table[hash_index][i][0] == key:
                self.table[hash_index][i] = list(self.table[hash_index][i])
                self.table[hash_index][i][1] = new_value
                self.table[hash_index][i] = tuple(self.table[hash_index][i])
                return
        
        return "No value to update"
    

def main():
    table = HashTable()
    table.put("kata", 1)
    table.put("royal", 5)
    table.put("raft", 4)
    # print(table.table)
    print(table.get_value("raft"))
    table.update_value("raft", 7)
    print(table.get_value("raft"))
    

if __name__ == "__main__":
    main()


