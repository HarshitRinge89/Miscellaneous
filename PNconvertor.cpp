#include <iostream>
#include <stack>
#include <algorithm>
using namespace std;
int prec(char c) {
    switch (c) {
        case '^': return 3;
        case '*': 
        case '/': return 2;
        case '+': 
        case '-': return 1;
        default: return -1;
    }
}
string funct(string &s) {
    stack<char> stk;
    string res;
    reverse(s.begin(),s.end());
    for (int i = 0; i < s.length(); i++) {
        char c = s[i];
        if (isalnum(c)) { 
            res += c;
        }
        else if (c == ')') {
            stk.push(c);
        }
        else if (c == '(') {
            while (!stk.empty() && stk.top() != '(') {
                res += stk.top();
                stk.pop();
            }
            if (!stk.empty()) stk.pop();
        }
        else { 
            while (!stk.empty() && prec(stk.top()) >= prec(c)) {
                res += stk.top();
                stk.pop();
            }
            stk.push(c);
        }
    }
    while (!stk.empty()) {
        res += stk.top();
        stk.pop();
    }
    reverse(res.begin(),res.end());
    return res;
}
int main() {
    string data;
    cout << "Enter the Infix Expression: ";
    cin >> data;
    cout << "The Postfix Expression: " << funct(data) << endl;
    return 0;
}
