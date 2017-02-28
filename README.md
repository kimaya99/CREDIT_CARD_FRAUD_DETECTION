# CreditCardFraudDetection
Credit Card usage has increased rapidly over the years. Online transactions are slowly taking over from door-to-door and market shopping. Hence, the amount of frauds in credit card transactions has also increased. Credit Card Fraud Detection needs to be efficiently implemented for banks to deal with and avoid online fraud transactions. This project uses Genetic Algorithm on customer’s credit card and transaction parameters to classify the transaction into three types of fraud. The three types are :
• Ordinary Fraud
• Moderate Fraud
• Significant Fraud

The front end is an online shopping website. It has various electronic devices available for shopping to all registered users. Any customer i.e. registered user can buy the product/s of his choice by providing authentic credit card details. The back end implements a Genetic Algorithm on details provided by the user , the bank and the onescalculated like Location, OverDraft, Amount, Card Usage etc. to classify the transaction into Ordinary, Moderate or Significant Fraud. The user has access only to the front end i.e. the interface of the site and has no idea about the calculations with respect to that transaction happening at the back end. The bank has access to the back end from where it gets the classification of every transaction as one of the three frauds. The bank takes an appropriate action on the basis of the classification of the transaction :
• Ordinary Fraud : No action.
• Moderate Fraud :Security Questions to check the authenticity of the transaction.
• Significant Fraud : Blocks the card.
