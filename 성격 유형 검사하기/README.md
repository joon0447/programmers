https://school.programmers.co.kr/learn/courses/30/lessons/118666

## 문제 설명
나만의 카카오 성격 유형 검사지를 만들려고 합니다.
성격 유형 검사는 다음과 같은 4개 지표로 성격 유형을 구분합니다. 성격은 각 지표에서 두 유형 중 하나로 결정됩니다.

<img width="268" height="176" alt="image" src="https://github.com/user-attachments/assets/74ae0405-efac-44f8-a8da-c3adac827e14" />

4개의 지표가 있으므로 성격 유형은 총 16(=2 x 2 x 2 x 2)가지가 나올 수 있습니다. 예를 들어, "RFMN"이나 "TCMA"와 같은 성격 유형이 있습니다.

검사지에는 총 n개의 질문이 있고, 각 질문에는 아래와 같은 7개의 선택지가 있습니다.

매우 비동의
비동의
약간 비동의
모르겠음
약간 동의
동의
매우 동의
각 질문은 1가지 지표로 성격 유형 점수를 판단합니다.

예를 들어, 어떤 한 질문에서 4번 지표로 아래 표처럼 점수를 매길 수 있습니다.

<img width="392" height="274" alt="image" src="https://github.com/user-attachments/assets/41cd8817-ab58-41ed-9e04-e29810f192db" />

이때 검사자가 질문에서 약간 동의 선택지를 선택할 경우 어피치형(A) 성격 유형 1점을 받게 됩니다. 만약 검사자가 매우 비동의 선택지를 선택할 경우 네오형(N) 성격 유형 3점을 받게 됩니다.

위 예시처럼 네오형이 비동의, 어피치형이 동의인 경우만 주어지지 않고, 질문에 따라 네오형이 동의, 어피치형이 비동의인 경우도 주어질 수 있습니다.
하지만 각 선택지는 고정적인 크기의 점수를 가지고 있습니다.

매우 동의나 매우 비동의 선택지를 선택하면 3점을 얻습니다.
동의나 비동의 선택지를 선택하면 2점을 얻습니다.
약간 동의나 약간 비동의 선택지를 선택하면 1점을 얻습니다.
모르겠음 선택지를 선택하면 점수를 얻지 않습니다.
검사 결과는 모든 질문의 성격 유형 점수를 더하여 각 지표에서 더 높은 점수를 받은 성격 유형이 검사자의 성격 유형이라고 판단합니다. 단, 하나의 지표에서 각 성격 유형 점수가 같으면, 두 성격 유형 중 사전 순으로 빠른 성격 유형을 검사자의 성격 유형이라고 판단합니다.

질문마다 판단하는 지표를 담은 1차원 문자열 배열 survey와 검사자가 각 질문마다 선택한 선택지를 담은 1차원 정수 배열 choices가 매개변수로 주어집니다. 이때, 검사자의 성격 유형 검사 결과를 지표 번호 순서대로 return 하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ survey의 길이 ( = n) ≤ 1,000
survey의 원소는 "RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA" 중 하나입니다.
survey[i]의 첫 번째 캐릭터는 i+1번 질문의 비동의 관련 선택지를 선택하면 받는 성격 유형을 의미합니다.
survey[i]의 두 번째 캐릭터는 i+1번 질문의 동의 관련 선택지를 선택하면 받는 성격 유형을 의미합니다.
choices의 길이 = survey의 길이
choices[i]는 검사자가 선택한 i+1번째 질문의 선택지를 의미합니다.
1 ≤ choices의 원소 ≤ 7
<img width="187" height="270" alt="image" src="https://github.com/user-attachments/assets/29745a23-be40-4916-95f1-8b402c49c714" />

## 입출력 예
<img width="499" height="98" alt="image" src="https://github.com/user-attachments/assets/cac77917-99a2-4853-b5ba-e63f672678cf" />

## 입출력 예 설명
입출력 예 #1

1번 질문의 점수 배치는 아래 표와 같습니다.

<img width="372" height="268" alt="image" src="https://github.com/user-attachments/assets/3c31f610-a923-49df-a6aa-685caef896ad" />

1번 질문에서는 지문의 예시와 다르게 비동의 관련 선택지를 선택하면 어피치형(A) 성격 유형의 점수를 얻고, 동의 관련 선택지를 선택하면 네오형(N) 성격 유형의 점수를 얻습니다.
1번 질문에서 검사자는 약간 동의 선택지를 선택했으므로 네오형(N) 성격 유형 점수 1점을 얻게 됩니다.

2번 질문의 점수 배치는 아래 표와 같습니다.

<img width="382" height="277" alt="image" src="https://github.com/user-attachments/assets/d541c6dc-90e8-43dd-998a-06cae4218760" />

2번 질문에서 검사자는 약간 비동의 선택지를 선택했으므로 콘형(C) 성격 유형 점수 1점을 얻게 됩니다.

3번 질문의 점수 배치는 아래 표와 같습니다.

<img width="375" height="266" alt="image" src="https://github.com/user-attachments/assets/a06e3540-e00a-49c6-904f-2b33b37bcd6e" />


3번 질문에서 검사자는 비동의 선택지를 선택했으므로 무지형(M) 성격 유형 점수 2점을 얻게 됩니다.

4번 질문의 점수 배치는 아래 표와 같습니다.

<img width="377" height="275" alt="image" src="https://github.com/user-attachments/assets/10771a47-9fad-4b06-9317-e2f48edabdb3" />

4번 질문에서 검사자는 매우 동의 선택지를 선택했으므로 튜브형(T) 성격 유형 점수 3점을 얻게 됩니다.

5번 질문의 점수 배치는 아래 표와 같습니다.

<img width="380" height="268" alt="image" src="https://github.com/user-attachments/assets/e31aad21-957d-4151-a640-4985d7c0fb06" />

5번 질문에서 검사자는 약간 동의 선택지를 선택했으므로 어피치형(A) 성격 유형 점수 1점을 얻게 됩니다.

1번부터 5번까지 질문의 성격 유형 점수를 합치면 아래 표와 같습니다.

<img width="418" height="165" alt="image" src="https://github.com/user-attachments/assets/21abe792-00f2-4ed4-8eae-568d1bda1de9" />

각 지표에서 더 점수가 높은 T,C,M이 성격 유형입니다.
하지만, 4번 지표는 1점으로 동일한 점수입니다. 따라서, 4번 지표의 성격 유형은 사전순으로 빠른 A입니다.

따라서 "TCMA"를 return 해야 합니다.

입출력 예 #2

1번부터 3번까지 질문의 성격 유형 점수를 합치면 아래 표와 같습니다.

<img width="421" height="159" alt="image" src="https://github.com/user-attachments/assets/3f5406cb-fc73-4ee6-972a-9ccd9b10a08f" />

1번 지표는 튜브형(T)보다 라이언형(R)의 점수가 더 높습니다. 따라서 첫 번째 지표의 성격 유형은 R입니다.
하지만, 2, 3, 4번 지표는 모두 0점으로 동일한 점수입니다. 따라서 2, 3, 4번 지표의 성격 유형은 사전순으로 빠른 C, J, A입니다.

따라서 "RCJA"를 return 해야 합니다.
