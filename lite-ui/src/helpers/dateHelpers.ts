const convertToDateTime = (date: Date) => {
    const year = formatDateNumber(date.getFullYear());
    const months = formatDateNumber(date.getMonth() + 1); // Months are zero-indexed
    const days = formatDateNumber(date.getDate());
    return `${year}-${months}-${days}`
}

const formatDateNumber = (number: number): string => {
    return number > 10 ? number + '' : ('0' + number);
}


export { convertToDateTime }